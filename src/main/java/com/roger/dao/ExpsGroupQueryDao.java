package com.roger.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roger.entity.CisSchemaConfig;
import com.roger.repository.CisSchemaConfigRepository;

@Component(value = "expsGroupQueryDao")
public class ExpsGroupQueryDao {

	@Autowired
	private CisSchemaConfigRepository configRepository;

	public String findKeyByColumnName(String columnName) {
		return configRepository.findFirstByColumnName(columnName).getKey();
	}

	public List<String> findTableNamesByKeyOrderByPriorityDESC(String key) {
		List<CisSchemaConfig> configs = configRepository.findByKeyOrderByPriorityDesc(key);
		
		List<String> tableNames = new ArrayList<String>();
		for(CisSchemaConfig config : configs) {
			String tableName = config.getTableName();
			if(!tableNames.contains(tableName))
				tableNames.add(tableName);
		}
		
		return tableNames;
	}
}
