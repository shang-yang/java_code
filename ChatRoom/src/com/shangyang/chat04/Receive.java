package com.shangyang.chat04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装：接收端
 * @author shangyang
 *
 */
public class Receive implements Runnable{

	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg = receive();
			if(!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}
	
	// 接收消息
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
		}
		return msg;
	}
	
	
	private void release() {
		this.isRunning = false;
		SyUtils.close(dis,client);
	}
}
