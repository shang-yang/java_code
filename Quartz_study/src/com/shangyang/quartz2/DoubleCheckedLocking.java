package com.shangyang.quartz2;

/**
 * 单例模式：套路，在多线程环境下，对外存在一个对象
 * 1、构造器私有化 --> 避免外部new创建
 * 2、提供似有的静态属性 --> 存储对象的地址
 * 3、提供公共的静态方法 --> 获取属性
 * @author shangyang
 *
 */
public class DoubleCheckedLocking {
	private static volatile DoubleCheckedLocking instance;
	//没有valitle可能访问到没有初始化的instance对象
	private DoubleCheckedLocking() {
		
	}
	
	public static DoubleCheckedLocking getInstance() {
		if(null != instance) {	//避免不必要的同步，已经存在对象
			return instance;
		}
		synchronized(DoubleCheckedLocking.class) {
			if(null == instance) {
				instance = new DoubleCheckedLocking();
				// 1、开辟空间
				// 2、初始化对象信息
				// 3、返回对象的地址给引用
			}
			return instance;
		}
	}
}
