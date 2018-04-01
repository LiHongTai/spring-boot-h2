package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CardInfo;
import com.roger.initdata.CardInfoMockData;
import com.roger.repository.CardInfoRepository;

@RestController
public class CardInfoController {

	@Autowired
	private CardInfoRepository repository;

	@RequestMapping(value = "/h2/saveCardInfo")
	public List<CardInfo> saveCardInfo() {
		List<CardInfo> infos = CardInfoMockData.getCardInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCardInfos")
	public List<CardInfo> findAllCardInfos(){
		return repository.findAll();
	}
	
}
