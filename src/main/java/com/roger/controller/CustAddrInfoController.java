package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CustAddrInfo;
import com.roger.initdata.CustAddrInfoMockData;
import com.roger.repository.CustAddrInfoRepository;

@RestController
public class CustAddrInfoController {

	@Autowired
	private CustAddrInfoRepository repository;

	@RequestMapping(value = "/h2/saveCustAddrInfo")
	public List<CustAddrInfo> saveCustAddrInfo() {
		List<CustAddrInfo> infos = CustAddrInfoMockData.getCustAddrInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCustAddrInfos")
	public List<CustAddrInfo> findAllCustAddrInfos(){
		return repository.findAll();
	}
	
}
