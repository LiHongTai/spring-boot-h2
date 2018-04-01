package com.roger.mockdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CardInfo;
import com.roger.entity.CustAccountInfo;
import com.roger.entity.CustAddrInfo;
import com.roger.entity.CustMainInfo;

public class RequestParmMockData {

	
	public static CustMainInfo createCustMainInfo() {
		//第一层 custMainInfo 客户信息
		CustMainInfo custMainInfo = new CustMainInfo();
		custMainInfo.setCustNo("cust001");
		
		//第二层 custAddrInfo 客户地址
		List<CustAddrInfo> custAddrInfos = new ArrayList<>();
		CustAddrInfo custAddrInfo = new CustAddrInfo();
		custAddrInfo.setCustAddr("盛夏路");
		custAddrInfos.add(custAddrInfo);
		
		//第二层 custAccountInfo 账户信息
		List<CustAccountInfo> custAccountInfos = new ArrayList<>();
		CustAccountInfo custAccountInfo = new CustAccountInfo();
		custAccountInfo.setAccountNo("zhaoshang001");
		
		//第三层 银行卡信息
		List<CardInfo> cardInfos = new ArrayList<>();
		CardInfo cardInfo = new CardInfo();
		cardInfo.setCardNo("925910");;
		custAccountInfo.setCardInfos(cardInfos);
		
		custAccountInfos.add(custAccountInfo);
		
		
		return custMainInfo;
	}
	
}
