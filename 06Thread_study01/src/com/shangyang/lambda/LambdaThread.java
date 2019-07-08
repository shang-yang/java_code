package com.shangyang.lambda;

/**
 * Lambda表达式 简化线程（用一次）的使用
 * @author shangyang
 *
 */
public class LambdaThread {

	//静态内部类
	static class Test implements Runnable{
		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				System.out.println("一边听歌");
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		//创建实现类对象
//		Test sr = new Test();
//		//创建代理类对象
//		Thread t =new Thread(sr);
//		//驱动
//		t.start();	//不保证立即运行，cpu调用
		
		//new Thread(new StartRun()).start();
		
		//st.run();	普通方法调用
		
		
		//局部内部类
		class Test2 implements Runnable{
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("一边听歌");
				}
			}
		}
		//new Thread(new Test2()).start();

		//匿名内部类 必须借助接口或者父类
//		new Thread(new Runnable() {
//			public void run() {
//				for(int i = 0; i < 10; i++) {
//					System.out.println("一边听歌");
//				}
//			}
//		}).start();
		
		
		//jdk8 简化 lambda
		new Thread(()-> {
				for(int i = 0; i < 10; i++) {
					System.out.println("一边听歌");
				}
		}).start();
		
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("一边coding");
		}
	}
	
}
