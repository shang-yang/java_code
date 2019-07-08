package com.shangyang.test;

import java.util.Date;

/**
 * 测试Date类常用方法
 * @author shangyang
 *
 */
public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getTime());
		long now = System.currentTimeMillis();
		System.out.println(now);
	}
}
