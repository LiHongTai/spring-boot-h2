package com.roger.utils;

import java.util.Map;

import org.junit.Test;

import com.roger.BaseTestSuit;

public class EntityUtilTest extends BaseTestSuit {

	@Test
	public void testGetEntityInfo() {
		Map<String, String> entityInfo = EntityUtil.getEntityName4DbTableName();
		for (Map.Entry<String, String> entity : entityInfo.entrySet()) {
			System.out.println("tableName:" + entity.getKey() + ";className:" + entity.getValue());
		}
	}
}
