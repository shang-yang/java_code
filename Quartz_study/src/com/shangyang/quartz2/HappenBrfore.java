package com.shangyang.quartz2;

/**
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * @author shangyang
 *
 */
public class HappenBrfore {
	private static int a = 0;
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		while(true) {
			a = 0;
			flag = false;
		// 线程1 更改数据
		Thread t = new Thread(()->{
			a = 1;
			flag = true;
		});
		// 线程2 读取数据
		Thread t2 = new Thread(()->{
			if(flag) {
				a *= 1;
			}
			if(a == 0) {
				System.out.println("happen before a->" + a);
			}
		}) ;
		t.start();
		t2.start();
		
		// 合并线程
		t.join();
		t2.join();
		}
	}
}
