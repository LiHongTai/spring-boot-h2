package com.roger.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {

	public static List<?> getDatas(Class<?> classType, String methodName, Object... args) {
		List<?> dataList = new ArrayList<>();
		try {
			Method[] methods = classType.getDeclaredMethods();
			Object result = null;
			for (Method method : methods) {
				String currentMethodName = method.getName();
				if (methodName.equals(currentMethodName)) {
					result = method.invoke(SpringContextUtil.getBean(classType), args);
					break;
				}
			}
			dataList = (List<?>) result;
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return dataList;
	}

	public static Object getFieldValue(Object entity, String fieldName) {
		Object fieldValue = null;
		try {
			Field field = entity.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			if (field != null)
				fieldValue = field.get(entity);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return fieldValue;
	}

	public static boolean isContain(Class<?> entityClass, String columnName) {
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			if (columnName.equals(fieldName))
				return true;
		}

		return false;
	}
}