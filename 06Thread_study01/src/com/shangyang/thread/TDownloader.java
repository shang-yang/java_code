package com.shangyang.thread;

public class TDownloader extends Thread {

	private String url;	//远程路径
	private String name;	//存储名字
	
	
	public TDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}


	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
	}
	
	public static void main(String[] args) {
		TDownloader td1 = new TDownloader("http://pic1.win4000.com/pic/5/c8/65cde5e3b0.jpg","a.jpg");
		TDownloader td2 = new TDownloader("http://pic1.win4000.com/pic/2/ef/eedd85585c.jpg","b.jpg");
		TDownloader td3 = new TDownloader("http://pic1.win4000.com/pic/2/5a/a39da70f64.jpg","c.jpg");
		
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}
