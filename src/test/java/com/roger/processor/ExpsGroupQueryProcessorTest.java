package com.roger.processor;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.roger.BaseTestSuit;
import com.roger.request.OperationModel;

public class ExpsGroupQueryProcessorTest extends BaseTestSuit{

	@Resource(name = "expsGroupQueryProcessor")
	private ExpsGroupQueryProcessor processor;

	@Test
	public void testDoProcessor() {
		OperationModel operationModel = new OperationModel();

		JSONObject inputData = new JSONObject();
		operationModel.setInputData(inputData);

		//inputData.put("custName", "钢铁侠 || 超人 || 小叮当");
		inputData.put("custAge", ">=30 || <=20");
		inputData.put("custSex", "男");
		operationModel.setOutputSchema("custNo,custName,custAge,custSex,custCode");

		JSONObject result = processor.doExpsGroupQuery(operationModel);
		System.out.println("得到的结果为:" + JSON.toJSONString(result,true));
	}

}
