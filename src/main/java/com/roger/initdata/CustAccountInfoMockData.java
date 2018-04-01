package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CustAccountInfo;

public class CustAccountInfoMockData {

	public static List<CustAccountInfo> getCustAccountInfos() {
		List<CustAccountInfo> custAccountInfos = new ArrayList<CustAccountInfo>();
		
		custAccountInfos.add(createCustAccountInfo("zhaoshang001","招商银行","11","cust001"));
		custAccountInfos.add(createCustAccountInfo("zhaoshang002","招商银行","22","cust001"));
		custAccountInfos.add(createCustAccountInfo("zhaoshang003","招商银行","33","cust002"));
		custAccountInfos.add(createCustAccountInfo("pingan001","平安银行","44","cust003"));
		
		return custAccountInfos;
	}
	
	private static CustAccountInfo createCustAccountInfo(String accountNo,String accountName,String accountInfo,String custNo) {
		CustAccountInfo custAccountInfo = new CustAccountInfo();
		
		custAccountInfo.setAccountInfo(accountInfo);
		custAccountInfo.setAccountName(accountName);
		custAccountInfo.setAccountNo(accountNo);
		custAccountInfo.setCustNo(custNo);
		
		return custAccountInfo;
	}
}
