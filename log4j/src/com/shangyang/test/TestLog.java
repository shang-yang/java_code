package com.shangyang.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog {
	public static void main(String[] args) {
		Hello hello = new Hello();
		Hi hi = new Hi();
		hello.getHello();
		hi.getHi();
	}
}

class Hello {
	private static Logger logger = LogManager.getLogger(Hello.class.getName());
	public void getHello() {
		logger.trace("我是trace信息");
		logger.debug("我是debug信息");
		logger.info("我是info信息");
		logger.warn("我是warn信息");
		logger.error("我是error信息"); 
		logger.fatal("我是fatal信息"); 
	}
}

class Hi {
	private static Logger logger = LogManager.getLogger(Hi.class);
	public void getHi() {
		logger.trace("我是trace信息");
		logger.debug("我是debug信息");
		logger.info("我是info信息");
		logger.warn("我是warn信息");
		logger.error("我是error信息"); 
		logger.fatal("我是fatal信息"); 
	}
}
