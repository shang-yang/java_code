package com.shangyang.state;

/**
 * yield礼让线程，暂停线程 直接进入就绪状态，不是阻塞状态
 * @author shangyang
 *
 */
public class YieldDemo {

	public static void main(String[] args) {
		MyYield my = new MyYield();
		new Thread(my,"a").start();
		new Thread(my,"b").start();
		new Thread(()->{
			for(int i = 0; i < 10; i++) {
				System.out.println("lambda.." + i);
			}
		}).start();
	}
}

class MyYield implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "--start");
		Thread.yield();//礼让
		System.out.println(Thread.currentThread().getName() + "--end");
	}
	
}