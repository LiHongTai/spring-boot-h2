package com.roger.parser;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roger.constant.CisConstant;

import static com.roger.constant.CisConstant.*;

public class ComplexQueryParser {

	public static JSONObject parse(String key, String columnName, String queryCondition) {
		String prefix = FIND + StringUtils.capitalize(key) + BY;
		if (queryCondition.contains(OR_SIGN))
			return handlerOrExpression(prefix, columnName, queryCondition);

		JSONObject complexQuery = new JSONObject();
		JSONObject methodNameAndArg = achieveMethodNameAndArg(queryCondition, prefix + StringUtils.capitalize(columnName));
		achieveQueryConditon(complexQuery, methodNameAndArg.getString(METHOD_NAME))
				.add(methodNameAndArg.getString(ARG_VALUE));

		return complexQuery;
	}

	private static JSONObject handlerOrExpression(String prefix, String columnName, String queryCondition) {
		JSONObject complexQuery = new JSONObject();

		String[] args = queryCondition.split(SEPERATOR_OR);
		for (String arg : args) {
			JSONObject methodNameAndArg = achieveMethodNameAndArg(arg, prefix + StringUtils.capitalize(columnName));
			achieveQueryConditon(complexQuery, methodNameAndArg.getString(METHOD_NAME))
					.add(methodNameAndArg.getString(ARG_VALUE));
		}

		return complexQuery;
	}

	private static JSONObject achieveMethodNameAndArg(String arg, String prexfix) {
		JSONObject methodNameAndArgValue = new JSONObject();
		StringBuilder methodName = new StringBuilder(prexfix);
		if(arg.contains(CisConstant.LESS_THAN_SIGN)) {
			methodName.append(CisConstant.LESS_THAN);
			arg = arg.replace(CisConstant.LESS_THAN_SIGN, CisConstant.EMPTY);
		}
		
		if(arg.contains(CisConstant.GREATER_THAN_SIGN)) {
			methodName.append(CisConstant.GREATER_THAN);
			arg = arg.replace(CisConstant.GREATER_THAN_SIGN, CisConstant.EMPTY);
		}
		
		if(arg.contains(CisConstant.EQUAL_SIGN)) {
			methodName.append(CisConstant.EQUAL);
			arg = arg.replace(CisConstant.EQUAL_SIGN, CisConstant.EMPTY);
		}
		
		methodNameAndArgValue.put(METHOD_NAME, methodName);
		methodNameAndArgValue.put(ARG_VALUE, arg.trim());
		return methodNameAndArgValue;

	}

	private static JSONArray achieveQueryConditon(JSONObject complexQuery, String methodName) {
		if (!complexQuery.containsKey(methodName))
			complexQuery.put(methodName, new JSONArray());
		return (JSONArray) complexQuery.get(methodName);
	}

}
