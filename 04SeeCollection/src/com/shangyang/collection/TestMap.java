package com.shangyang.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的使用
 * @author shangyang
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map<Integer,String> m1 = new HashMap<>();
		
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		m1.put(4, "four");
		m1.put(5, "five");
		System.out.println(m1);
		System.out.println(m1.size());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("sex"));
		
		Map<Integer,String> m2 = new HashMap<>();
		m2.put(1, "lala");
		
		m1.putAll(m2);
		System.out.println(m1);
	}
}
