package com.shangyang;

import java.util.Arrays;

/**
 * 测试冒泡排序
 * @author shangyang
 *
 */
public class TestBubbleSort {

	public static void main(String[] args) {
		
		int[] values = {34,12,4,7,39,66,3,1};
		int temp;
		for(int i = 0; i < values.length-1; i++) {
			for(int j = 0; j < values.length-1-i; j++) {
				if(values[j] > values[j+1]) {
					temp = values[j];
					values[j] = values[j+1];
					values[j+1] = temp;
				}
				System.out.println(Arrays.toString(values));
			}
			System.out.println("**********************");
		}
	}
}
