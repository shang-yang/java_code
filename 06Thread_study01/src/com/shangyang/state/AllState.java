package com.shangyang.state;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * @author shangyang
 *
 */
public class AllState {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("...");
			}
		});
		
		//观察状态
		State state = t.getState();
		System.out.println(state);	//NEW
		
		t.start();
		state = t.getState();
		System.out.println(state);	//RUNNABLE
		
		while(state!=Thread.State.TERMINATED) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state = t.getState();
			System.out.println(state);	//TIMED_WAITING
		}
	}
}
