package com.shangyang.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * sleep模拟倒计时
 * @author shangyang
 *
 */
public class BlockedSleep01 {

	public static void main(String[] args) throws InterruptedException {
		test2();
	}
	public static void test1() throws InterruptedException {
		//倒数10个数，一秒一个
		int num =10;
		while(num >= 0) {
			Thread.sleep(1000);
			System.out.println(num--);
		}
		
	}
	public static void test2() throws InterruptedException {
		//倒计时
		Date endTime = new Date(System.currentTimeMillis()+1000*10);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime()-1000);
			if(end-10000 > endTime.getTime()) {
				break;
			}
		}
	}
	
	
}
