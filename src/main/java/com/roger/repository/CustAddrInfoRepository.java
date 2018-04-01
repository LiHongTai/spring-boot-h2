package com.roger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CustAddrInfo;

public interface CustAddrInfoRepository extends JpaRepository<CustAddrInfo, Long> {

	List<CustAddrInfo> findByCustNo(String custNo);
}
