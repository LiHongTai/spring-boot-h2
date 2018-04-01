package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CreditInfo;

public class CreditInfoMockData {

	public static List<CreditInfo> getCreditInfos() {
		List<CreditInfo> creditInfos = new ArrayList<CreditInfo>();
		
		creditInfos.add(createCreditInfo("credit001", "2000","30"));
		creditInfos.add(createCreditInfo("credit002", "2000","90"));
		creditInfos.add(createCreditInfo("credit003", "5000","90"));
		creditInfos.add(createCreditInfo("credit004", "1000","90"));
		
		return creditInfos;
	}
	
	private static CreditInfo createCreditInfo(String creditNo,String creditAmount,String creditTime) {
		CreditInfo creditInfo = new CreditInfo();
		
		creditInfo.setCreditAmount(creditAmount);
		creditInfo.setCreditNo(creditNo);
		creditInfo.setCreditTime(creditTime);
		
		return creditInfo;
	}
}
