package com.shangyang.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.shangyang.bean.User;

/**
 * 通过反射API动态操作：构造器、方法、属性
 * @author shangyang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		String path = "com.shangyang.bean.User";
		
		try {
			Class<User> c = (Class<User>)Class.forName(path);
			
			//动态调用构造方法，构造对象
			User u = (User)c.newInstance();	//调用了User的无参构造方法
			
			//通过API调用普通方法
			Method method = c.getDeclaredMethod("setName", String.class);
			method.invoke(u, "lalala");
			System.out.println(u.getName());
			
			
			Constructor<User> uc = c.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = uc.newInstance(1001,18,"王尼玛");
			System.out.println(u2.getName());
			
			
			//通过反射API操作属性
			Field f = c.getDeclaredField("name");
			
			f.setAccessible(true);	//这个属性不用进行安全检查了，可以直接使用
			f.set(u, "shangyang");	//通过反射直接写属性
			
			System.out.println(f.get(u));	//通过反射直接读属性
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
