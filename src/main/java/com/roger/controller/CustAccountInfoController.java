package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CustAccountInfo;
import com.roger.initdata.CustAccountInfoMockData;
import com.roger.repository.CustAccountInfoRepository;

@RestController
public class CustAccountInfoController {

	@Autowired
	private CustAccountInfoRepository repository;

	@RequestMapping(value = "/h2/saveCustAccountInfo")
	public List<CustAccountInfo> saveCustAccountInfo() {
		List<CustAccountInfo> infos = CustAccountInfoMockData.getCustAccountInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCustAccountInfos")
	public List<CustAccountInfo> findAllCustAccountInfos(){
		return repository.findAll();
	}
	
}
