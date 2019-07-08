package com.shangyang.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点：计算机、路由、通信设备等
 * InetAddress:提供了多个静态方法
 * 1、getLocalHost：本机
 * 2、getByName:根据域名DNS|IP地址 --> IP
 * 
 * 两个成员方法
 * 1、getHostAddress:返回地址
 * 2、getHostName:返回计算机名
 * @author shangyang
 *
 */
public class IpTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		//根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}
}
