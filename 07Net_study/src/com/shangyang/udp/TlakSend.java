package com.shangyang.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端：使用面向对象封装
 * @author shangyang
 *
 */
public class TlakSend implements Runnable{

	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;
	public TlakSend(int port,String toIP, int toPort) {
		this.toIP = toIP;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			String data;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
				client.send(packet);
				if(data.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		client.close();
	}
}
