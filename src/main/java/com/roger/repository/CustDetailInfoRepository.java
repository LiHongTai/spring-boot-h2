package com.roger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CustDetailInfo;

public interface CustDetailInfoRepository extends JpaRepository<CustDetailInfo, Long> {

	List<CustDetailInfo> findByCustAge(String custAge);

	List<CustDetailInfo> findByCustNo(String custNo);

	List<CustDetailInfo> findByCustAgeLessThan(String custAge);

	List<CustDetailInfo> findByCustAgeLessThanEqual(String custAge);

	List<CustDetailInfo> findByCustAgeGreaterThan(String custAge);

	List<CustDetailInfo> findByCustAgeGreaterThanEqual(String custAge);

	List<CustDetailInfo> findByCustSex(String custSex);
}
