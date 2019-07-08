package com.shangyang.randtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随即读取和写入流 RandomAccessFile
 * @author shangyang
 *
 */
public class RandTest {

		public static void main(String[] args) throws IOException {
			test01();
		}
		
		//指定起始位置,读取剩余所有内容
		public static void test01() throws IOException {
			RandomAccessFile raf = new RandomAccessFile(new File("/home/shangyang/BZCXY/java_code/IO_study03/src/com/shangyang/printtest/PrintTest.java"),"r");
			//起始位置
			int beginPos = 2;
			//实际大小
			int actualSize = 1026;
			//随即读取
			raf.seek(beginPos);
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=raf.read(flush))!=-1) {
				if(actualSize > len) {	//读取本次获取的所有内容
				System.out.println(new String(flush,0,len));
				actualSize -= len;
				} else {
					System.out.println(new String(flush,0,actualSize));
				}
			}
			raf.close();
		}
}


	
