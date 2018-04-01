package com.roger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CardInfo;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long>{

}
