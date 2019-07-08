package com.shangyang.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo01 {

	public static void main(String[] args) {

		try {
			Class c = Class.forName("com.shangyang.test.annotation.SyStudent");
			
			//获得类的所有注解
			Annotation[] annotations = c.getAnnotations();
			for(Annotation a : annotations) {
				System.out.println(a);
			}
			
			// 获得类指定注解
			SyAnnotation01 sy = (SyAnnotation01)c.getAnnotation(SyAnnotation01.class);
			System.out.println(sy.value());
			
			
			// 获得类的属性的注解
			Field f = c.getDeclaredField("sname");
			SyField syf = f.getAnnotation(SyField.class);
			System.out.println(syf.columnName() + "---" + syf.type() + "---" + syf.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
