package com.shangyang.state;

/**
 * join合并线程，插队线程
 * @author shangyang
 *
 */
public class BlockJoin01 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			for(int i = 0; i < 20; i++) {
				System.out.println("lambda..." + i);
			}
		});
		t.start();
		
		for(int i = 0; i < 20; i ++) {
			if(i==5) {
				t.join();	//插队 main被阻塞了
			}
			System.out.println("main..." + i);
		}
	}
}
