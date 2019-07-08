package com.shangyang;

public class TestArrayCopy {
	public static void main(String[] args) {
		String[] s1 = {"aa","bb","cc","dd"};
		String[] s2 = new String[5];
		//数组的拷贝（可自己跟自己拷贝，从而删除某个元素）
		System.arraycopy(s1, 0, s2, 0, s1.length);
		for(String s:s2) {
			System.out.println(s);
		}
	}
}
