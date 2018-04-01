package com.roger.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.roger.constant.CisConstant;

public class RepositoryInstanceUtil {

	public RepositoryInstanceUtil() {

	}

	public static Class<?> getRepositoryInstance(String name,String nameType) {
		Map<String, Class<?>> repositoryInstance = new HashMap<>();
		
		if(CisConstant.ENTITY.equals(nameType))
			repositoryInstance = getRepositoryInstance4EntityName();
		
		if(CisConstant.DB_TABLE.equals(nameType))
			repositoryInstance = getRepositoryInstance4DbTableName();
			
		return repositoryInstance.get(name.toUpperCase());
	}

	public static Map<String, Class<?>> getRepositoryInstance4DbTableName() {
		Map<String, Class<?>> repositoryInstance4DbTableName = new HashMap<>();

		Map<String, String> entityName4DbTableName = EntityUtil.getEntityName4DbTableName();
		Map<String, Class<?>> repositoryInstance4EntityName = getRepositoryInstance4EntityName();
		for (Map.Entry<String, String> entity : entityName4DbTableName.entrySet()) {
			String dbTableName = entity.getKey();
			String entityName = entity.getValue();
			repositoryInstance4DbTableName.put(dbTableName, (Class<?>) repositoryInstance4EntityName.get(entityName));
		}

		return repositoryInstance4DbTableName;
	}

	public static Map<String, Class<?>> getRepositoryInstance4EntityName() {
		Map<String, Class<?>> repositoryInstance4EntityName = new HashMap<>();
		try {
			List<String> repositoryInstancePaths = PackageUtil.getClasses(CisConstant.ORACLE_REPOSITORY_INSTANCE_PATH);
			for (String repositoryInstancePath : repositoryInstancePaths) {
				Class<?> className = Class.forName(repositoryInstancePath);
				String simpleName = className.getSimpleName();
				String entityName = simpleName.split(CisConstant.ORACLE_REPOSITORY_INSTANCE_SPLIT_FLAG)[0];
				repositoryInstance4EntityName.put(entityName, className);
			}
		} catch (Exception e) {
			// TODO
		}
		return repositoryInstance4EntityName;
	}
}
