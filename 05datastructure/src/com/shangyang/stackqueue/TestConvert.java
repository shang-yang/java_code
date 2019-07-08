package com.shangyang.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 十进制转化为二进制
 * @author shangyang
 *
 */
public class TestConvert {

	public static void main(String[] args) {
		// 给定一个十进制数
		int n = 13;
		// 把十进制数转换成二进制
		int t = 13;//被除数
		
		// 定义一个空栈
		Deque stack = new LinkedList();
		
		do {
			//除以2求余数
			int mod = t %2;
			//输出余数
			//System.out.println(mod);
			//除以2得到商
			//int result = t / 2;
			//使用商做被除数
			// 入栈
			stack.push(mod);
			t = t / 2;
		}while(t > 0);	// 商>0
		// 输出结果
		System.out.println(n+"------>");
		while(stack.isEmpty()) {	// 当栈非空
			System.out.println(stack.pop());
		}
	}
}
