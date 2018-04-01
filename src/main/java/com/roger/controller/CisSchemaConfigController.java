package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.entity.CisSchemaConfig;
import com.roger.initdata.CisSchemaConfigMockData;
import com.roger.repository.CisSchemaConfigRepository;

@RestController
public class CisSchemaConfigController {

	@Autowired
	private CisSchemaConfigRepository schemaConfigRepository;

	@RequestMapping(value = "/h2/saveCisSchemaConfig")
	public List<CisSchemaConfig> saveCisSchemaConfig() {
		List<CisSchemaConfig> configs = CisSchemaConfigMockData.getCisSchemaConfigs();
		return schemaConfigRepository.save(configs);
	}
	
	@RequestMapping(value = "/h2/findAllConfigs")
	public List<CisSchemaConfig> findAllConfigs(){
		return schemaConfigRepository.findAll();
	}
	
}
