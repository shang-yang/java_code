package com.shangyang.udp;

/**
 * 加入多线程，实现双向交流，模拟在线咨询
 * @author shangyang
 *
 */
public class TalkStudent {

	public static void main(String[] args) {
		new Thread(new TlakSend(7777,"localhost",9999)).start();
		new Thread(new TalkReceive(8888)).start();//接收
	}
}
