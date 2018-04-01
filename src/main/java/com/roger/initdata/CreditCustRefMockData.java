package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CreditCustRef;

public class CreditCustRefMockData {

	public static List<CreditCustRef> getCreditCustRefs() {
		List<CreditCustRef> creditCustRefs = new ArrayList<CreditCustRef>();
		
		creditCustRefs.add(createCreditCustRef("credit001", "cust001"));
		creditCustRefs.add(createCreditCustRef("credit002", "cust001"));
		creditCustRefs.add(createCreditCustRef("credit003", "cust002"));
		creditCustRefs.add(createCreditCustRef("credit003", "cust003"));
		
		return creditCustRefs;
	}
	
	private static CreditCustRef createCreditCustRef(String creditNo,String custNo) {
		CreditCustRef creditCustRef = new CreditCustRef();
		
		creditCustRef.setCreditNo(creditNo);
		creditCustRef.setCustNo(custNo);
		
		return creditCustRef;
	}
}
