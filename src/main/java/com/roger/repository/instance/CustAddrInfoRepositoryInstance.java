package com.roger.repository.instance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roger.entity.CustAddrInfo;
import com.roger.repository.CustAddrInfoRepository;

@Component
public class CustAddrInfoRepositoryInstance {

	@Autowired
	private CustAddrInfoRepository repository;
	
	public List<CustAddrInfo> findByCustNo(String custNo){
		return repository.findByCustNo(custNo);
	}
}
