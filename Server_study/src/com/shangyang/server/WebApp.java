package com.shangyang.server;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {

	private static WebContext webContext;
	
	static {
		try {
			//SAX解析
			//1、获取解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//2、从解析工厂获取解析器
			SAXParser parse = factory.newSAXParser();
			//3、编写处理器
			//4、加载文档Document注册处理器
			WebHandler handler = new WebHandler();
			//5、解析
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), handler);
			// 获取数据
			webContext = new WebContext(handler.getEntitys(),handler.getMappings());
		} catch (Exception e) {
			System.out.println("解析配置文件出错");
		}
	}
	
	public static Servlet getServletFromUrl(String url) {
		String className = webContext.getClz("/"+url);
		Class clz;
		try {
			clz = Class.forName(className);
			Servlet servlet = (Servlet)clz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			
		}
		return null;
	}
}
