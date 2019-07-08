package com.shangyang.quartz2;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域
 * get/set/initialValue
 * @author shangyang
 *
 */
public class ThreadLocalTest {

	//private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	//更改初始值
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initialValue() {
//			return 200;
//		};
//	};
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		// 获取值
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		// 设置值
		threadLocal.set(1);
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		
		for(int i = 0 ; i < 5 ; i++) {
			new Thread(()->{
				Integer left = threadLocal.get();
				System.out.println(Thread.currentThread().getName() + "-->" + left);
				threadLocal.set(left-1);
				System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
			}) .start();
		}
	}
}
