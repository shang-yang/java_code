package com.shangyang.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射API，获取类的信息（类的名字、属性、方法、构造器等）
 * @author shangyang
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		String path = "com.shangyang.bean.User";
		
		try {
			Class<?> c = Class.forName(path);
			
			// 类的名字
			System.out.println(c.getName());	//获得包名+类名
			System.out.println(c.getSimpleName());	//获得类名
			
			//获得属性信息
			//Field[] fields = c.getFields();	//只能获得public的field
			Field[] fields = c.getDeclaredFields();	//获得所有的field
			for(Field temp : fields) {
				System.out.println(temp);
			}
			
			//获取方法信息
			Method[] methods = c.getDeclaredMethods();
			for(Method temp:methods) {
				System.out.println(temp);
			}
			//如果方法有参，则必须传递参数类型对应的class对象
			Method m1 = c.getDeclaredMethod("setName", String.class);	
			System.out.println(m1);
			
			
			// 获取构造器信息
			Constructor[] con = c.getDeclaredConstructors();
			Constructor con1 = c.getDeclaredConstructor(null);
			System.out.println(con1);
			for(Constructor temp:con) {
				System.out.println(temp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
