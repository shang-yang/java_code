package com.shangyang.syn;

/**
 * 数据不安全：出现负数或相同的值
 * @author shangyang
 *
 */
public class SafeTest {

	public static void main(String[] args) throws InterruptedException {
		//账户
		Account account = new Account(1000,"结婚礼金");
		SynDrawing you = new SynDrawing(account,80,"可悲的你");
		SynDrawing wife = new SynDrawing(account,90,"happy的她");
		you.start();
		wife.start();
	}
}



//模拟取款  线程安全
class SynDrawing extends Thread{
	Account account;	//取钱的账户
	int drawingMoney;	//取钱的钱数
	int packetTotal;	//口袋的钱数

	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		this.test();
	}
	
	public void test() {
		if(account.money <= 0) {
			return;
		}
		//同步块
		synchronized(account) {
		if(account.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->账户余额为：" + account.money);
		System.out.println(this.getName() + "-->口袋的钱为：" + packetTotal);
		}
	}
}