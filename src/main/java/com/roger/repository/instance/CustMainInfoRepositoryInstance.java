package com.roger.repository.instance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roger.entity.CustMainInfo;
import com.roger.repository.CustMainInfoRepository;

@Component
public class CustMainInfoRepositoryInstance {

	@Autowired
	private CustMainInfoRepository repository;
	
	public List<CustMainInfo> findByCustNo(String custNo){
		return repository.findByCustNo(custNo);
	}
	
	public List<String> findCustNoByCustName(String custName){
		List<CustMainInfo> infos = repository.findByCustName(custName);
		
		List<String> custNos = new ArrayList<>();
		for(CustMainInfo info : infos) {
			custNos.add(info.getCustNo());
		}
		
		return custNos;
	}
}
