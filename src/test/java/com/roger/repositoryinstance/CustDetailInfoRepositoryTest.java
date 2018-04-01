package com.roger.repositoryinstance;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.BaseTestSuit;
import com.roger.entity.CustDetailInfo;
import com.roger.repository.CustDetailInfoRepository;

public class CustDetailInfoRepositoryTest extends BaseTestSuit {

	@Autowired
	public CustDetailInfoRepository repository;
	
	@Test
	public void testFindByCustAge() {
		
		 List<CustDetailInfo> newDetailInfo = repository.findAll();
		 
		 for (CustDetailInfo custDetailInfo : newDetailInfo) {
			System.out.println(custDetailInfo.getCustAge());
		}
		 
	}
}
