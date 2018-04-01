package com.roger.repository.instance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roger.entity.CustDetailInfo;
import com.roger.repository.CustDetailInfoRepository;

@Component
public class CustDetailInfoRepositoryInstance {

	@Autowired
	private CustDetailInfoRepository repository;
	
	public List<String> findCustNoByCustAge(String custAge){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustAge(custAge);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<String> findCustNoByCustAgeLessThan(String custAge){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustAgeLessThan(custAge);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<String> findCustNoByCustAgeLessThanEqual(String custAge){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustAgeLessThanEqual(custAge);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<String> findCustNoByCustAgeGreaterThan(String custAge){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustAgeGreaterThan(custAge);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<String> findCustNoByCustAgeGreaterThanEqual(String custAge){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustAgeGreaterThanEqual(custAge);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<String> findCustNoByCustSex(String custSex){
		List<String> custNos = new ArrayList<>();
		List<CustDetailInfo> detailInfos = repository.findByCustSex(custSex);
		for (CustDetailInfo detailInfo : detailInfos) {
			custNos.add(detailInfo.getCustNo());
		}
		return custNos;
	}
	
	public List<CustDetailInfo> findByCustNo(String custNo){
		return repository.findByCustNo(custNo);
	}
}
