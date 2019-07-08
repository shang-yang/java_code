package com.shangyang.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 写出内容
 * @author shangyang
 *
 */
public class CIOTest04 {

	public static void main(String[] args) throws IOException {
		//写出内容
		FileUtils.write(new File("bbb.txt"),"hello,world\n" ,"UTF-8");
		FileUtils.writeStringToFile(new File("bbb.txt"), "you are very beautiful\n","UTF-8",true);
		FileUtils.writeByteArrayToFile(new File("bbb.txt"),"I LOVE YOU\n".getBytes("UTF-8"),true);
		
		
		//写出列表
		List<String> datas = new ArrayList<String>();
		datas.add("马云");
		datas.add("李京洋");
		datas.add("shangyang");
		
		FileUtils.writeLines(new File("bbb.txt"), datas,"...",true);
	}
}
