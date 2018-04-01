package com.roger.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import com.roger.constant.CisConstant;

public class EntityUtil {

	public EntityUtil() {
	}

	public static Map<String, String> getEntityName4DbTableName() {
		Map<String, String> entityInfoResult = new HashMap<String, String>();
		try {
			List<String> entityPaths = PackageUtil.getClasses(CisConstant.ORACLE_ENTITY_PATH);
			for (String entityPath : entityPaths) {
				Class<?> className = Class.forName(entityPath);
				if(className.isAnnotationPresent(Table.class)) {
					Table tableAnnotation = className.getAnnotation(Table.class);
					String dbTableName = tableAnnotation.name().toUpperCase();
					entityInfoResult.put(dbTableName, className.getSimpleName());
				}
			}
		} catch (Exception e) {
			//TODO
		}

		return entityInfoResult;
	}
	
	public static Class<?> getEntityClass(String dbTableName){
		return getEntityClass4DbTableName().get(dbTableName.toUpperCase());
	}
	
	private static Map<String, Class<?>> getEntityClass4DbTableName() {
		Map<String, Class<?>> entityInfoResult = new HashMap<>();
		try {
			List<String> entityPaths = PackageUtil.getClasses(CisConstant.ORACLE_ENTITY_PATH);
			for (String entityPath : entityPaths) {
				Class<?> className = Class.forName(entityPath);
				if(className.isAnnotationPresent(Table.class)) {
					Table tableAnnotation = className.getAnnotation(Table.class);
					String dbTableName = tableAnnotation.name().toUpperCase();
					entityInfoResult.put(dbTableName, className);
				}
			}
		} catch (Exception e) {
			//TODO
		}

		return entityInfoResult;
	}

}
