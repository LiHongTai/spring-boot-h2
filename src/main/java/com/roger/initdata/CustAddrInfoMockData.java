package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CustAddrInfo;

public class CustAddrInfoMockData {

	public static List<CustAddrInfo> getCustAddrInfos() {
		List<CustAddrInfo> custAddrInfos = new ArrayList<CustAddrInfo>();
		
		custAddrInfos.add(createCustAddrInfo("cust001", "盛夏路","123"));
		custAddrInfos.add(createCustAddrInfo("cust002", "祖冲之路","456"));
		
		return custAddrInfos;
	}
	
	private static CustAddrInfo createCustAddrInfo(String custNo,String custAddr,String custCode) {
		CustAddrInfo custAddrInfo = new CustAddrInfo();
		
		custAddrInfo.setCustNo(custNo);
		custAddrInfo.setCustAddr(custAddr);
		custAddrInfo.setCustCode(custCode);
		
		return custAddrInfo;
	}
}
