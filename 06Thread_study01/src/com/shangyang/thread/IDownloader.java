package com.shangyang.thread;

public class IDownloader implements Runnable {

	private String url;	//远程路径
	private String name;	//存储名字
	
	
	public IDownloader(String url, String name) {
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
		IDownloader td1 = new IDownloader("http://pic1.win4000.com/pic/5/c8/65cde5e3b0.jpg","a.jpg");
		IDownloader td2 = new IDownloader("http://pic1.win4000.com/pic/2/ef/eedd85585c.jpg","b.jpg");
		IDownloader td3 = new IDownloader("http://pic1.win4000.com/pic/2/5a/a39da70f64.jpg","c.jpg");
		
		
		//启动三个线程
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}
