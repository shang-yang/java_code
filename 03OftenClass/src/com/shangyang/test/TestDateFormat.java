package com.shangyang.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的互相转换
 * @author shangyang
 *
 */
public class TestDateFormat {

	public static void main(String[] args) {
		
		//把时间对象按照“格式字符串指定的格式”转成相应的字符串
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = df.format(new Date());
		System.out.println(str);
		
		//把字符串按照“格式字符串指定的格式”转成相应的时间对象
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date date = df2.parse("2016-07-13 10:45:34");
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//测试其他的格式字符
		SimpleDateFormat df3 = new SimpleDateFormat("D");
		String str3 = df3.format(new Date());
		System.out.println(str3);
	}
}
