package com.roger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CustAccountInfo;

public interface CustAccountInfoRepository extends JpaRepository<CustAccountInfo, Long> {

}
