package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CustMainInfo;

public class CustMainInfoMockData {

	public static List<CustMainInfo> getCustMainInfos() {
		List<CustMainInfo> custMainInfos = new ArrayList<CustMainInfo>();
		
		custMainInfos.add(createCustMainInfo("cust001", "超人"));
		custMainInfos.add(createCustMainInfo("cust002", "钢铁侠"));
		custMainInfos.add(createCustMainInfo("cust003", "钢铁侠"));
		custMainInfos.add(createCustMainInfo("cust004", "小叮当"));
		custMainInfos.add(createCustMainInfo("cust005", "巴拉巴拉小魔仙"));
		
		return custMainInfos;
	}
	
	private static CustMainInfo createCustMainInfo(String custNo,String custName) {
		CustMainInfo custMainInfo = new CustMainInfo();
		
		custMainInfo.setCustNo(custNo);
		custMainInfo.setCustName(custName);
		
		return custMainInfo;
	}
}
