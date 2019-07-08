package com.shangyang.sorm.utils;

import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 * @author shangyang
 *
 */
public class ReflectUtils {

	/**
	 * 调用obj对象对应属性fieldName的get方法
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName,Object obj) {
		// 通过反射机制，调用属性对应的get方法或set方法
		try {
			Class c = obj.getClass();
			Method m = c.getMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
			return m.invoke(obj, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void invokeSet(Object obj,String columnName,Object columnValue) {
		// 通过反射机制，调用属性对应的get方法或set方法
		try {
			Class c = obj.getClass();
			Method m = c.getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(columnName),
					columnValue.getClass());
			
			m.invoke(obj, columnValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
