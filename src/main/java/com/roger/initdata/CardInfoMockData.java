package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CardInfo;

public class CardInfoMockData {

	public static List<CardInfo> getCardInfos() {
		List<CardInfo> cardInfos = new ArrayList<CardInfo>();
		
		cardInfos.add(createCardInfo("925910", "zhaoshang001","zs001"));
		cardInfos.add(createCardInfo("925901", "zhaoshang002","zs002"));
		cardInfos.add(createCardInfo("62591123", "zhaoshang003","zs005"));
		cardInfos.add(createCardInfo("62592311", "pingan001","90"));
		
		return cardInfos;
	}
	
	private static CardInfo createCardInfo(String cardNo,String accountNo,String bankId) {
		CardInfo cardInfo = new CardInfo();
		
		cardInfo.setCardNo(cardNo);
		cardInfo.setAccountNo(accountNo);
		cardInfo.setBankId(bankId);
		
		return cardInfo;
	}
}
