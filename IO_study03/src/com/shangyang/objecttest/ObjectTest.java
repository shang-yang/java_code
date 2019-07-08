package com.shangyang.objecttest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 对象流
 * 1.写出后读取
 * 2.读取的顺序与写出保持一致
 * 3.不是所有的对象都可以序列化Serializable
 * 
 * ObjectOutputStream
 * ObjectInputStream
 * @author shangyang
 *
 */
public class ObjectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream dos = new ObjectOutputStream(baos);
		//操作数据类型 + 数据
		dos.writeUTF("编码辛酸泪");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		//对象
		dos.writeObject("谁解其中味！");
		dos.writeObject(new Date());
		dos.flush();
		
		byte[] datas = baos.toByteArray();
		//读取
		ObjectInputStream dis = new ObjectInputStream(new ByteArrayInputStream(datas));
		
		//顺序与写出一致
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(msg + age + flag + ch + dis.readObject().toString() + dis.readObject());
	}
}
