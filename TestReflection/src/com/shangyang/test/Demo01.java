package com.shangyang.test;


/**
 * 测试java.lang.Class对象的获取方式
 * @author shangyang
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		String path = "com.shangyang.bean.User";
		
		try {
			Class<?> c = Class.forName(path);
			
			Class str = String.class;
			Class str2 = str.getClass();
			
			int a[] = new int[10];
			String str3 = new String();
			Class i = a.getClass();
			Class s = str3.getClass();
			
			System.out.println(i.hashCode());
			System.out.println(str2.hashCode());
			System.out.println(str.hashCode());
			System.out.println(s.hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
