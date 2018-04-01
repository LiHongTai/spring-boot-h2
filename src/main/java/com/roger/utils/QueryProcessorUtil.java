package com.roger.utils;

import static com.roger.constant.CisConstant.BY;
import static com.roger.constant.CisConstant.DB_TABLE;
import static com.roger.constant.CisConstant.FIND;
import static com.roger.constant.CisConstant.INDEX_COLUMN;
import static com.roger.constant.CisConstant.INDEX_COLUMN_VALUE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roger.parser.ComplexQueryParser;

@SuppressWarnings("unchecked")
public class QueryProcessorUtil {

	public static Set<String> obtainKeyValueSet(List<String> dbTableNames, JSONObject queryParam, String key) {
		Set<String> keyValueSet = null;
		//循环请求条件中所有列
		for (String columnName : queryParam.keySet()) {
			//获取所在列对应的表 对应的查询服务类
			Class<?> repositotyInstance = obtainRepositoryInstance(columnName, dbTableNames);
			String queryCondition = queryParam.getString(columnName);
			//里面有方法名和方法名对应的参数值信息
			JSONObject queryExpression = ComplexQueryParser.parse(key, columnName, queryCondition);
			if (keyValueSet == null) {
				keyValueSet = new HashSet<>();
				keyValueSet
						.addAll((Collection<? extends String>) obtainKeyValueList(repositotyInstance, queryExpression));
				continue;
			}
			keyValueSet
					.retainAll((Collection<? extends String>) obtainKeyValueList(repositotyInstance, queryExpression));
		}
		return keyValueSet;
	}

	private static Class<?> obtainRepositoryInstance(String columnName, List<String> dbTableNames) {
		for (String dbTableName : dbTableNames) {
			Class<?> entityClass = EntityUtil.getEntityClass(dbTableName);
			if (ReflectUtil.isContain(entityClass, columnName))
				return RepositoryInstanceUtil.getRepositoryInstance(dbTableName, DB_TABLE);
		}
		return null;
	}

	private static List<String> obtainKeyValueList(Class<?> repositotyInstance, JSONObject queryExpression) {
		List<String> keyValueList = new ArrayList<>();
		for (String methodName : queryExpression.keySet()) {
			keyValueList.addAll(obtainKeyValueList4MethodName(repositotyInstance, methodName,
					queryExpression.getJSONArray(methodName)));
		}
		return keyValueList;
	}

	private static List<String> obtainKeyValueList4MethodName(Class<?> repositotyInstance, String methodName,
			JSONArray args) {
		List<String> keyValueList = new ArrayList<>();
		for (Object arg : args) {
			keyValueList
					.addAll((Collection<? extends String>) ReflectUtil.getDatas(repositotyInstance, methodName, arg));
		}
		return keyValueList;
	}

	public static JSONArray obtainOutputSchemaResult(List<String> datasourceTableNames, JSONObject indexColumnInfo,
			List<String> outputSchemas) {
		String key = indexColumnInfo.getString(INDEX_COLUMN);
		Set<String> args = (Set<String>) indexColumnInfo.get(INDEX_COLUMN_VALUE);
		String methodName = FIND + BY + StringUtils.capitalize(key);

		JSONObject tableDatas = new JSONObject();
		for (String dbTableName : datasourceTableNames) {
			Class<?> repositotyInstance = RepositoryInstanceUtil.getRepositoryInstance(dbTableName, DB_TABLE);
			tableDatas.put(dbTableName, obtainKeyValueList4MethodName(repositotyInstance, methodName, args));
		}
		JSONArray outputDatas = new JSONArray();
		for (String arg : args) {
			JSONObject outputData = assembleOutputData(arg, key, outputSchemas, tableDatas);
			outputDatas.add(outputData);
		}
		return outputDatas;
	}

	private static List<Object> obtainKeyValueList4MethodName(Class<?> repositotyInstance, String methodName,
			Set<String> args) {
		List<Object> keyValueList = new ArrayList<>();
		for (String arg : args) {
			keyValueList.addAll(ReflectUtil.getDatas(repositotyInstance, methodName, arg));
		}
		return keyValueList;
	}

	private static JSONObject assembleOutputData(String arg, String key, List<String> outputSchemas,
			JSONObject tableDatas) {
		JSONObject outputData = new JSONObject();
		for (String columnName : outputSchemas) {
			Object entityInfo = obtainEntityInfo(arg, key, columnName, tableDatas);
			if (entityInfo == null)
				continue;

			outputData.put(columnName, ReflectUtil.getFieldValue(entityInfo, columnName));
		}
		return outputData;
	}

	private static Object obtainEntityInfo(String arg,String key, String columnName, JSONObject tableDatas) {
		for(String dbTableName : tableDatas.keySet()) {
			Class<?> entityClass = EntityUtil.getEntityClass(dbTableName);
			if(ReflectUtil.isContain(entityClass, columnName))
				return obtainEntityInfo(arg,key,(List<Object>) tableDatas.get(dbTableName));
		}
		return null;
	}

	private static Object obtainEntityInfo(String arg,String key,List<Object> entities) {
		for (Object entity : entities) {
			Object keyValue = ReflectUtil.getFieldValue(entity, key);
			if(arg.equals(keyValue))
				return entity;
		}
		return null;
	}
}
