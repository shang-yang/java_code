package com.shangyang.io02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStream
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 * @author shangyang
 *
 */
public class ConvertTest2 {

	public static void main(String[] args) {
		//操作网络流，下载百度的源代码
		try(BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(
								new URL("https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4").openStream(),"UTF-8"));
			BufferedWriter writer = 
					new BufferedWriter (
							new OutputStreamWriter(
									new FileOutputStream("/home/shangyang/桌面/a.html"),"UTF-8"
									));){
			String msg = null;
			;
			while((msg = reader.readLine()) != null) {
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			System.out.println("操作异常！");
		}
	}
}
