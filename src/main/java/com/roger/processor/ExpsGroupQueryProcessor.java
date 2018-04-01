package com.roger.processor;

import static com.roger.constant.CisConstant.INDEX_COLUMN;
import static com.roger.constant.CisConstant.INDEX_COLUMN_VALUE;
import static com.roger.constant.CisConstant.SEPERATOR_COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roger.dao.ExpsGroupQueryDao;
import com.roger.request.OperationModel;
import com.roger.utils.EntityUtil;
import com.roger.utils.QueryProcessorUtil;
import com.roger.utils.ReflectUtil;
import com.roger.utils.ResponseUtil;

@Component(value = "expsGroupQueryProcessor")
public class ExpsGroupQueryProcessor {

	@Resource(name = "expsGroupQueryDao")
	private ExpsGroupQueryDao expsGroupQueryDao;

	public JSONObject doExpsGroupQuery(OperationModel operationModel) {
		long startTime = System.currentTimeMillis();
		// 定义查询主key列，即类似索引字段 key = custNo
		JSONObject indexColumnInfo = new JSONObject();
		JSONObject queryParam = (JSONObject) operationModel.getInputData();
		for (String columnName : queryParam.keySet()) {
			indexColumnInfo.put(INDEX_COLUMN, expsGroupQueryDao.findKeyByColumnName(columnName));
			break;
		}
		// 得到key值对应的所有表信息,按照priority从高到低排序
		List<String> dbTableNames = expsGroupQueryDao
				.findTableNamesByKeyOrderByPriorityDESC(indexColumnInfo.getString(INDEX_COLUMN));
		//获取到所有满足请求条件key列所对应的所有值，custNo = [cust001,cust002] 
		indexColumnInfo.put(INDEX_COLUMN_VALUE, QueryProcessorUtil.obtainKeyValueSet(dbTableNames, queryParam,
				indexColumnInfo.getString(INDEX_COLUMN)));
		
		List<String> datasourceTableNames = obtainDataSourceTableName(dbTableNames, obtainOutputSchema(operationModel));
		JSONArray result = QueryProcessorUtil.obtainOutputSchemaResult(datasourceTableNames,indexColumnInfo,obtainOutputSchema(operationModel));
		long endTime = System.currentTimeMillis();
		return ResponseUtil.addResponseSuccess(result, endTime - startTime);
	}

	private List<String> obtainOutputSchema(OperationModel operationModel){
		String outputSchema = operationModel.getOutputSchema();
		String[] schemas = outputSchema.split(SEPERATOR_COMMA);
		return new ArrayList<>(Arrays.asList(schemas));
	}
	
	private List<String> obtainDataSourceTableName(List<String> dbTableNames, List<String> outputSchemas) {
		List<String> datasourceTableNames = new ArrayList<>();
		for (int i = dbTableNames.size() - 1; i >= 0; i--) {
			String dbTableName = dbTableNames.get(i);
			Class<?> entityClass = EntityUtil.getEntityClass(dbTableName);

			if (validateOutputSchema(outputSchemas, entityClass))
				datasourceTableNames.add(dbTableName);

			if (CollectionUtils.isEmpty(outputSchemas))
				break;
		}

		return datasourceTableNames;
	}

	private boolean validateOutputSchema(List<String> outputSchemas, Class<?> entityClass) {
		boolean flag = false;
		List<String> hasOutputSchemas = new ArrayList<>();
		for (String columnName : outputSchemas) {
			if (ReflectUtil.isContain(entityClass, columnName)) {
				flag = true;
				hasOutputSchemas.add(columnName);
			}
		}
		outputSchemas.removeAll(hasOutputSchemas);
		return flag;
	}
}
