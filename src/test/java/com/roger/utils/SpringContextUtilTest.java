package com.roger.utils;

import org.junit.Test;

import com.roger.BaseTestSuit;
import com.roger.repository.instance.CustMainInfoRepositoryInstance;

public class SpringContextUtilTest extends BaseTestSuit {
	
	@Test
	public void testGetBean() {
		CustMainInfoRepositoryInstance repositoryInstance = SpringContextUtil.getBean("custMainInfoRepositoryInstance");
		System.out.println(repositoryInstance.toString());
	}
}
