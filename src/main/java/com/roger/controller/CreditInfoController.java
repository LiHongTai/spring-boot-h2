package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CreditInfo;
import com.roger.initdata.CreditInfoMockData;
import com.roger.repository.CreditInfoRepository;

@RestController
public class CreditInfoController {

	@Autowired
	private CreditInfoRepository repository;

	@RequestMapping(value = "/h2/saveCreditInfo")
	public List<CreditInfo> saveCreditInfo() {
		List<CreditInfo> infos = CreditInfoMockData.getCreditInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCreditInfos")
	public List<CreditInfo> findAllCreditInfos(){
		return repository.findAll();
	}
	
}
