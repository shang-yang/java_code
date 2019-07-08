package com.shangyang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 * @author shangyang
 *
 */
public class TalkReceive implements Runnable{
	private DatagramSocket server;
	

	public TalkReceive(int port) {
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			 // 2、准备容器 封装成DatagramPacket 包裹
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
			 // 3、阻塞式接收包裹receive(DatagramPacket p)
			try {
				server.receive(packet);
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String data = new String(datas,0,len);
				System.out.println(data);
				if(data.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 // 5、释放资源
		server.close();
	}
}
