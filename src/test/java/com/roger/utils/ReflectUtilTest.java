package com.roger.utils;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.roger.BaseTestSuit;
import com.roger.constant.CisConstant;
import com.roger.entity.CustMainInfo;

public class ReflectUtilTest extends BaseTestSuit {

	@SuppressWarnings("unchecked")
	@Test
	public void testGetModelDataByRepository() {
		String dbTableName = "CUST_ADDR_INFO";
		Class<?> modelRepositoryInstance = RepositoryInstanceUtil.getRepositoryInstance(dbTableName, CisConstant.DB_TABLE);
		
		String methodName = "findByCustNo";
		String param = "cust001";
		
		List<CustMainInfo> custMainInfos = (List<CustMainInfo>) ReflectUtil.getDatas(modelRepositoryInstance, methodName, param);
		for (CustMainInfo custMainInfo : custMainInfos) {
			System.out.println(custMainInfo.getCustName());
		}
	}
	
	@Test
	public void testGetFieldValue() {
		String custNo = "cust001";
		CustMainInfo custMainInfo = new CustMainInfo();
		custMainInfo.setCustNo(custNo);
		
		Object result = ReflectUtil.getFieldValue(custMainInfo, "custNo");
		
		assertTrue(custNo.equals(result));
		
	}
}
