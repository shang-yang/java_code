package com.shangyang.state;

public class BlockJoin02 {

	public static void main(String[] args) {
		System.out.println("爸爸和儿子卖烟的故事");
		new Thread(new Father()).start();
	}
}

class Father extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("想抽烟，发现烟没了");
		System.out.println("让儿子买烟");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();	//father被阻塞
			System.out.println("抽烟");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("孩子走丢了，2333333333");
		}
		
	}
}

class Son extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("接过了钱出去买烟");
		System.out.println("路边有个游戏厅，玩了10秒");
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println(i + "秒过去了");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("赶紧买烟去");
		System.out.println("买完回家");
	}
}