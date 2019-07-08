package com.shangyang.lambda;

/**
 * lambda推导 + 参数 + 返回值
 * @author shangyang
 *
 */
public class LambdaTest4 {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("一边学习")).start();
		
		new Thread(() ->  {
			for(int i=0;i<10;i++) {
			System.out.println("一边啦啦啦");
			}
		}).start();
	}
}
