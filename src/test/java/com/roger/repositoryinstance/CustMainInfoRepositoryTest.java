package com.roger.repositoryinstance;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.BaseTestSuit;
import com.roger.entity.CustMainInfo;
import com.roger.repository.CustMainInfoRepository;

public class CustMainInfoRepositoryTest extends BaseTestSuit {

	@Autowired
	private CustMainInfoRepository repository;
	
	@Test
	public void testFindByCustNo() {
		List<CustMainInfo> infos = repository.findAll();
		for (CustMainInfo custMainInfo : infos) {
			System.out.println(custMainInfo.getCustName());
		}
	}
}
