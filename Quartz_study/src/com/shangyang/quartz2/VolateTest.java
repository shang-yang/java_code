package com.shangyang.quartz2;

/**
 * volatile用于保证数据的同步，也就是可见性
 * @author shangyang
 *
 */
public class VolateTest {

	private volatile static int num = 0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num==0) {
				
			}
		}) .start();
		Thread.sleep(1000);
		num = 1;
	}
	
}
