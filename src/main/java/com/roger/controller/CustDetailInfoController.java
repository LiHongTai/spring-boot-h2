package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CustDetailInfo;
import com.roger.initdata.CustDetailInfoMockData;
import com.roger.repository.CustDetailInfoRepository;

@RestController
public class CustDetailInfoController {

	@Autowired
	private CustDetailInfoRepository repository;

	@RequestMapping(value = "/h2/saveCustDetailInfo")
	public List<CustDetailInfo> saveCustDetailInfo() {
		List<CustDetailInfo> infos = CustDetailInfoMockData.getCustDetailInfos();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCustDetailInfos")
	public List<CustDetailInfo> findAllCustDetailInfos(){
		return repository.findAll();
	}
	
}
