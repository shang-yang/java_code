package com.shangyang.state;
/**
 * 守护线程，是为用户线程服务的，JVM停止不用等=等待守护线程执行完毕
 * 默认：用户线程
 * @author shangyang
 *
 */
public class DaemonTest {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		Thread t = new Thread(god);//将用户线程设置为守护线程
		//t.setDaemon(true);
		t.start();
		new Thread(you).start();
	}
}

class You implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i < 15; i++) {
			System.out.println("happy every day!");
		}
		System.out.println("ooooo2333");
	}
}

class God implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true) {
			System.out.println("with you" + i++);
		}
	}
}