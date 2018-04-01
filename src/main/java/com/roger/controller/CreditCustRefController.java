package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CreditCustRef;
import com.roger.initdata.CreditCustRefMockData;
import com.roger.repository.CreditCustRefRepository;

@RestController
public class CreditCustRefController {

	@Autowired
	private CreditCustRefRepository repository;

	@RequestMapping(value = "/h2/saveCreditCustRef")
	public List<CreditCustRef> saveCreditCustRef() {
		List<CreditCustRef> infos = CreditCustRefMockData.getCreditCustRefs();
		return repository.save(infos);
	}
	
	@RequestMapping(value = "/h2/findAllCreditCustRefs")
	public List<CreditCustRef> findAllCreditCustRefs(){
		return repository.findAll();
	}
	
}
