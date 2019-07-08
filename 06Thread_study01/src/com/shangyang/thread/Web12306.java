package com.shangyang.thread;

/**
 * 共享资源,并发（线程安全）
 * @author shangyang
 *
 */
public class Web12306 implements Runnable{

	//票数
	private int tickeNums = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(tickeNums < 0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + tickeNums--);
		}
	}
	
	public static void main(String[] args) {
		//一份资源
		Web12306 web = new Web12306();
		//多个代理
		new Thread(web,"a").start();
		new Thread(web,"bb").start();
		new Thread(web,"ccc").start();
	}
}
