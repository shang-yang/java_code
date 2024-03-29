package com.shangyang.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：处理404 505 和首页
 * @author shangyang
 *
 */
public class Server {

	private ServerSocket serverSocket;
	private boolean isRunning;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	// 驱动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("驱动服务器失败...");
			stop();
		}
	}
	
	//接收连接处理
	public void receive() {
		while(isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接...");
				//多线程处理
				new Thread(new Dispatcher(client)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}
	
	//停止服务
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
