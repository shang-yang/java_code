package com.shangyang.thread;

/**
 * 模拟龟兔赛跑
 * @author shangyang
 *
 */
public class Racer implements Runnable{

	private static String winner;//胜利者

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int steps = 1; steps <= 100; steps++) {
			//模拟休息
			if(Thread.currentThread().getName().equals("兔    子") && steps%10 == 00) {
				//try {
					//Thread.sleep(1);
					System.out.println(Thread.currentThread().getName() + "又睡觉了");
					
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
			}
			System.out.println(Thread.currentThread().getName() + "-->" + steps);
			//比赛是否结束
			boolean flag = gameOver(steps);
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner !=null) {	//存在胜利者
			return true;
		} else {
			if(steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner ==>" + winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer,"乌龟").start();
		new Thread(racer,"兔    子").start();
	}
}
