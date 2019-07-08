package com.shangyang.search;

/**
 * 功能：在分数中查询指定分数的索引
 * @author shangyang
 *
 */
public class TestSearch1 {

	public static void main(String[] args) {
		// 给定分数数组
		int [] scoreArr = {89,45,100,98,86,100,65};
		// 给定要查找的分数
		int score = 100;
		// 完成查找
		int index = search(scoreArr,score);
		// 输出结果
		if(index == -1) {
			System.out.println("该分数不存在");
		} else {
			System.out.println(score + "的索引是" + index);
		}
	}
	
	/**
	 * 时间复杂度  T(n) = O(n)
	 * 空间复杂度  S(n) = O(1)
	 * @param arr 待查找的数组
	 * @param score	查找的值
	 * @return 如果找到，返回索引；如果未找到，返回-1
	 */
	public static int search(int [] arr,int score) {
		int index = -1;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == score) {
				index = i;
				break;
			}
		}
		return index;
	}
}
