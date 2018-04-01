package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CustMainInfo;
import com.roger.initdata.CustMainInfoMockData;
import com.roger.repository.CustMainInfoRepository;

@RestController
public class CustMainInfoController {

	@Autowired
	private CustMainInfoRepository repository;

	@RequestMapping(value = "/h2/saveCustMainInfo")
	public List<CustMainInfo> saveCustMainInfo() {
		List<CustMainInfo> infos = CustMainInfoMockData.getCustMainInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCustMainInfos")
	public List<CustMainInfo> findAllCustMainInfos(){
		return repository.findAll();
	}
	
}
