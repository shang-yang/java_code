package com.shangyang.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型：发送端	  
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、将基本类型 转成字节数组
 * 3、封装成 DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 * @author shangyang
 *
 */
public class UdpTypeClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中....");
//		1、使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
//		2、 将基本类型 转成字节数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		//操作数据类型 + 数据
		dos.writeUTF("编码辛酸泪");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		
		byte[] datas = baos.toByteArray();
				
//		3、 封装成 DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
//		4、 发送包裹send(DatagramPacket p)
		client.send(packet);
//		5、 释放资源
		client.close();
	}
}
