package com.shangyang.io;

/**
 * 实现放大器对声音的放大
 * @author shangyang
 *
 */
public class DecorateTest01 {

	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		
		Amplifier a = new Amplifier(p);
		a.say();
	}
	
}

interface Say {
	void say();
}

class Person implements Say{
	//属性
	private int voice = 10;
	
	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("人的声音为：" + this.getVoice());
	}
}

//放大器
class Amplifier implements Say{
	private Person p;

	Amplifier(Person p) {
		this.p = p;
	}
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("人的声音为：" + p.getVoice()*100);
		System.out.println("噪音。。。");
	}
	
}





