package com.roger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CreditInfo;

public interface CreditInfoRepository extends JpaRepository<CreditInfo, Long> {

}
