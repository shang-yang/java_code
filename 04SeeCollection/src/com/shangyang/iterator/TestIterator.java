package com.shangyang.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历List、Set、Map
 * @author shangyang
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		//testIteratorList();
		//testIteratorSet();
		testIteratorMap();
	}
	
	public static void testIteratorList() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		for(Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	
	public static void testIteratorSet() {
		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		for(Iterator<String> iter = set.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	
	public static void testIteratorMap() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(100, "aa");
		map.put(200, "bb");
		map.put(300, "cc");
		
		//第一中遍历方式
		Set<Entry<Integer,String>> ss = map.entrySet();
		for(Iterator<Entry<Integer,String>> iter = ss.iterator();iter.hasNext();) {
			Entry<Integer,String> temp = iter.next();
			System.out.println(temp.getKey() + "---" + temp.getValue());
		}
		
		//第二种遍历方式
		Set<Integer> keySet = map.keySet();
		 for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
	            Integer key = iterator.next();
	            System.out.println(key + "--" + map.get(key));
	        }
	}
}
