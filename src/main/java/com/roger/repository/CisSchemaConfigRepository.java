package com.roger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.entity.CisSchemaConfig;

public interface CisSchemaConfigRepository extends JpaRepository<CisSchemaConfig, Long> {

	CisSchemaConfig findFirstByColumnName(String columnName);
	
	List<CisSchemaConfig> findByKeyOrderByPriorityDesc(String key);
}
