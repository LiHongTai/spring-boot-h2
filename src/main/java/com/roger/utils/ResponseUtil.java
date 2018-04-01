package com.roger.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {

	private static final String RESPONSE_CODE = "responseCode";
	private static final String RESPONSE_DATA = "responseData";
	private static final String COST_TIME = "costTime";
	private static final String TOTAL_COUNT = "totalCount";
	
	private static final String SUCCESS_STATUS = "0";
	
	public static JSONObject addResponseSuccess(JSONArray resultJsonArray,long costTime) {
		JSONObject responseResult = new JSONObject();
		responseResult.put(RESPONSE_CODE, SUCCESS_STATUS);
		responseResult.put(RESPONSE_DATA, resultJsonArray);
		responseResult.put(TOTAL_COUNT, resultJsonArray.size());
		responseResult.put(COST_TIME, costTime);
		return responseResult;
	}
}
