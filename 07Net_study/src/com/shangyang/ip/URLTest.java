package com.shangyang.ip;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL：统一资源定位器，互联网三大基石之一（html http url），区分资源
 * 1、协议
 * 2、域名、计算机
 * 3、端口：默认80
 * 4、请求资源
 * @author shangyang
 *
 */
public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baodi.com:80/index.html?uname=sy&age=16#a");
		
		System.out.println(url.getProtocol() + "--协议");
		System.out.println(url.getHost() + "--域名|IP");
		System.out.println(url.getPort() + "--端口");
		System.out.println(url.getPath() + "--请求资源");
		System.out.println(url.getFile() + "--请求资源");
		
		//参数
		System.out.println(url.getQuery() + "--参数");
		//锚点
		System.out.println(url.getRef() + "--锚点");
	}
}
