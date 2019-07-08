package com.shangyang;

import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 * @author shangyang
 *
 */
public class TestArray {

	public static void main(String[] args) {
		int[] a = {1,2,7,54,23,99,2345,324,5};
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("该元素的索引："+Arrays.binarySearch(a, 99));
		Arrays.fill(a, 2, 4, 0);
		System.out.println(Arrays.toString(a));
	}
}
