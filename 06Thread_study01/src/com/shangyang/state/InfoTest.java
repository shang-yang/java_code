package com.shangyang.state;

/**
 * 其他方法
 * isAlive：表示线程是否还或者
 * Thread.currentThread()：当前线程
 * @author shangyang
 *
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		//设置名称：真实角色 + 代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread t = new Thread(info);
		t.setName("公鸡");
		t.start();
		
		Thread.sleep(100);
		System.out.println(t.isAlive());
	}
}

class MyInfo implements Runnable{
	
	private String name;
	
	public MyInfo(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "-->" + name);
	}
}