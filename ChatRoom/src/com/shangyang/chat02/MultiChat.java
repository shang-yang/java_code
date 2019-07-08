package com.shangyang.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室 ： 服务器
 * 目标：使用多线程实现多个客户可以正常收发多条消息
 * @author shangyang
 *
 */
public class MultiChat {

	public static void main(String[] args) throws IOException {
		System.out.println("------server-------");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		while(true) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(()->{
				// 3、接收消息
				DataInputStream dis = null;
				DataOutputStream dos = null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				boolean isRunninng = true;
				while(isRunninng) {
					String datas;
					try {
						datas = dis.readUTF();
						dos.writeUTF(datas);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						isRunninng = false;
					}
					// 4、返回消息
					
				}	
				try {
					if(null == dos) {
						dos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(null == dis) {
						dis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(null == client) {
						client.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
	}
}
