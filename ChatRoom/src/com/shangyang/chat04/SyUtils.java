package com.shangyang.chat04;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 * @author shangyang
 *
 */
public class SyUtils {

	/**
	 * 释放资源
	 */
	public static void close(Closeable... targets) {
		for(Closeable target:targets) {
			try {
				if(null!=target) {
					target.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
