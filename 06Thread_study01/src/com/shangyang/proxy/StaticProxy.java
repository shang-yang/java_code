package com.shangyang.proxy;

/**
 * 静态代理
 * 公共接口：
 * 1、真实角色
 * 2、代理角色
 * @author shangyang
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	}
}

interface Marry{
	void happyMarry();
}

/**
 * 真实角色
 * @author shangyang
 *
 */
class You implements Marry {
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and 嫦娥终于奔月了...");
	}
}

/**
 * 代理角色
 * @author shangyang
 *
 */
class WeddingCompany implements Marry {
	private Marry target;

	public WeddingCompany(Marry target) {
		super();
		this.target = target;
	}

	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		ready();
		this.target.happyMarry();
		after();
	}
	private void ready() {
		System.out.println("布置卧室");
	}
	private void after() {
		System.out.println("闹洞房");
	}
}