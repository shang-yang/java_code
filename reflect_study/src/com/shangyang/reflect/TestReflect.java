package com.shangyang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射学习 获取类对象
 * 
 * @author shangyang
 *
 */
public class TestReflect {

	public static void main(String[] args) throws Exception {
		// 反射操作类属性
		Class c = Class.forName("com.shangyang.test.Student");
		System.out.println("获取类对象的包名：" + c.getPackage());
		System.out.println("获取类的修饰符：" + c.getModifiers());
		System.out.println("获取类的名称（全限定）：" + c.getName());
		System.out.println("获取类的名称（类名）:" + c.getSimpleName());
		System.out.println("获取类的父类的类对象：" + c.getSuperclass());
		System.out.println("----------------------------");
		
		// 获取所有的公共方法（包括父类）
		Method[] methods = c.getMethods();
		for(Method method:methods) {
			System.out.println(method.getName());
		}
		System.out.println("----------------------------");
		// 获取所有声明的方法（不包括父类）
		Method[] methodall= c.getDeclaredMethods();
		for(Method method:methodall) {
			System.out.println(method.getName());
		}
		// 获取指定的公共方法
	
		
	}

	public static void field() throws Exception {
		// 获取反射类属性
		Class c = Class.forName("com.shangyang.test.Student");
		// 获取该类及其所有父类的所有公共字段
		System.out.println("获取该类及其所有父类的所有公共字段");
		Field[] fields = c.getFields();
		for (Field f : fields) {
			System.out.println("获取属性名：" + f.getName());
			System.out.println("获取修饰符" + f.getModifiers());
			System.out.println("获取类型" + f.getType()); // 返回的是类型的Class对象
			System.out.println("----------------------------");
		}

		// 获取该类声明的所有字段
		System.out.println(" 获取该类声明的所有字段");
		Field[] fieldall = c.getDeclaredFields();
		for (Field f : fieldall) {
			System.out.println("获取属性名：" + f.getName());
			System.out.println("获取修饰符" + f.getModifiers());
			System.out.println("获取类型" + f.getType()); // 返回的是类型的Class对象
			System.out.println("----------------------------");
		}

		// 获取指定的字段(只能获取公共字段)
		// 指定获取类及其父类的公共字段
		Field field = c.getField("pname");
		System.out.println(field.getName());

		// 指定获取类的所有字段
		Field field2 = c.getDeclaredField("snull");
		System.out.println(field2.getName());

		// 指定获取父类声明字段
		Field field3 = c.getSuperclass().getDeclaredField("pname");

	}
}
