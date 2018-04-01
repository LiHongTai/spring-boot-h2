package com.roger.initdata;

import java.util.ArrayList;
import java.util.List;

import com.roger.entity.CisSchemaConfig;

public class CisSchemaConfigMockData {

	public static List<CisSchemaConfig> getCisSchemaConfigs() {
		List<CisSchemaConfig> schemaConfigs = new ArrayList<CisSchemaConfig>();
		
		//cust_main_info
		schemaConfigs.add(createCisSchemaConfig4Level0("custNo", "cust_main_info", "9"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custName", "cust_main_info", "9"));
		
		//cust_addr_info
		schemaConfigs.add(createCisSchemaConfig4Level0("custNo", "cust_addr_info", "8"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custAddr", "cust_addr_info", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custCode", "cust_addr_info", "1"));
		
		//cust_detail_info
		schemaConfigs.add(createCisSchemaConfig4Level0("custNo", "cust_detail_info", "7"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custName", "cust_detail_info", "8"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custAge", "cust_detail_info", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level0("custSex", "cust_detail_info", "1"));
		
		//cust_account_info
		schemaConfigs.add(createCisSchemaConfig4Level1("accountNo", "cust_account_info", "9"));
		schemaConfigs.add(createCisSchemaConfig4Level1("accountName", "cust_account_info", "9"));
		schemaConfigs.add(createCisSchemaConfig4Level1("accountInfo", "cust_account_info", "9"));
		schemaConfigs.add(createCisSchemaConfig4Level1("custNo", "cust_account_info", "6"));
		
		//credit_info
		schemaConfigs.add(createCisSchemaConfig4Level2("creditNo", "credit_info", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level2("creditAmount", "credit_info", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level2("creditTime", "credit_info", "1"));
		//credit_cust_ref
		schemaConfigs.add(createCisSchemaConfig4Level2("id", "credit_cust_ref", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level2("custNo", "credit_cust_ref", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level2("creditNo", "credit_cust_ref", "1"));
		
		//card_info
		schemaConfigs.add(createCisSchemaConfig4Level3("accountNo", "card_info", "8"));
		schemaConfigs.add(createCisSchemaConfig4Level3("cardNo", "card_info", "1"));
		schemaConfigs.add(createCisSchemaConfig4Level3("bankId", "card_info", "1"));
		return schemaConfigs;
	}

	private static CisSchemaConfig createCisSchemaConfig4Level0(String columnName, String tableName, String priority) {
		CisSchemaConfig config = new CisSchemaConfig();

		config.setLevel("0");
		config.setKey("custNo");
		config.setNecessary("Y");

		config.setColumnName(columnName);
		config.setTableName(tableName);
		config.setPriority(priority);
		
		return config;
	}
	
	private static CisSchemaConfig createCisSchemaConfig4Level1(String columnName, String tableName, String priority) {
		CisSchemaConfig config = new CisSchemaConfig();

		config.setLevel("1");
		config.setKey("accountNo");
		config.setNecessary("Y");

		config.setColumnName(columnName);
		config.setTableName(tableName);
		config.setPriority(priority);
		
		return config;
	}
	
	private static CisSchemaConfig createCisSchemaConfig4Level2(String columnName, String tableName, String priority) {
		CisSchemaConfig config = new CisSchemaConfig();

		config.setLevel("2");
		config.setKey("creditNo");
		config.setNecessary("Y");

		config.setColumnName(columnName);
		config.setTableName(tableName);
		config.setPriority(priority);
		
		return config;
	}
	
	private static CisSchemaConfig createCisSchemaConfig4Level3(String columnName, String tableName, String priority) {
		CisSchemaConfig config = new CisSchemaConfig();

		config.setLevel("3");
		config.setKey("cardNo");
		config.setNecessary("Y");

		config.setColumnName(columnName);
		config.setTableName(tableName);
		config.setPriority(priority);
		
		return config;
	}
}
