package com.shangyang.printtest;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流PrintStream
 * @author shangyang
 *
 */
public class PrintTest {

	public static void main(String[] args) throws IOException {
		//打印流System,out
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("a.txt")),true);
//		Scanner sc = new Scanner(System.in);
//		while(!(sc.nextLine()).equals("exit")) {
//			ps.println(sc.nextLine());
//			ps.flush();
//		}
		//重定向到输出端
		System.setOut(ps);
		System.out.println("change");
		
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("change");
	}
}
