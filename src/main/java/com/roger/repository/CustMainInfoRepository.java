package com.roger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CustMainInfo;

public interface CustMainInfoRepository extends JpaRepository<CustMainInfo, Long> {

	List<CustMainInfo> findByCustNo(String custNo);
	
	List<CustMainInfo> findByCustName(String custName);
}
