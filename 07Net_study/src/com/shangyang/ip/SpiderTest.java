package com.shangyang.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫原理 + 模拟浏览器
 * @author shangyang
 *
 */
public class SpiderTest {

	public static void main(String[] args) throws IOException {
		// 获取URL
		URL url = new URL("https://www.jd.com");
		// 下载资源
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg = null;
		while(null != (msg=br.readLine())) {
			System.out.println(msg);
		}
		br.close();
		// 分析
		// 处理
	}
}
