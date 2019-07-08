package com.shangyang.search;

/**
 * 前提：顺序结构，有序
 * @author shangyang
 *
 */
public class TestSearch2 {

	public static void main(String[] args) {
		// 给定数组
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		// 给定要查找的值
		int key = 4;
		// 进行查找
		
		int index = binarySearch(array,key);
		// 输出结果
		if(index == -1) {
			System.out.println("该分数不存在");
		} else {
			System.out.println(key + "的索引是" + index);
		}
	}
	
	/**
	 * 不使用递归的折半查找
	 * T(n) = O (logn)
	 * S(n) = O (1)
	 * @param array 待查找的数组
	 * @param key   查找的值
	 * @return  如果找到，返回索引；如果未找到，返回-1
	 */
	public static int binarySearch1(int[] array,int key) {
		// 指定low 和 high
		int low = 0;
		int high = array.length - 1;
		// 折半查找
		while (low <= high) {
			// 求得mid
			int mid = (low + high) / 2;
			// 判断是否等于
			if(key == array[mid]) {
				return mid;
			} else if (key < array[mid]) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 使用递归的折半查找
	 * T(n) = O (logn)
	 * S(n) = O (1*logn)
	 * @param array 待查找的数组
	 * @param key   查找的值
	 * @return  如果找到，返回索引；如果未找到，返回-1
	 */
	public static int binarySearch(int [] array,int key) {
		// 指定low 和 high
		int low = 0;
		int high = array.length - 1;
		return binarySearch(array,key,low,high);
	}
	
	public static int binarySearch(int[] array,int key,int low, int high) {
		// 递归结束条件
		if(low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if(key == array[mid]) {
			return mid;
		} else if(key < array[mid]) {
			return binarySearch(array,key,low,mid-1);
		} else {
			return binarySearch(array,key,mid+1,high);
		}
	}
}
