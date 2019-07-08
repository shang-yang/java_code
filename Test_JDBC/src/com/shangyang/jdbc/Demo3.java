package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PrepareStatement的基本用法
 * @author shangyang
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		try {
			// 加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 建立连接（连接对象内容其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			// 真正开发中，为了提高效率，都会使用连接池来管理连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			
			String sql = "insert into user (username,password) values (?,?)";	// ?占位符
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "李四");
			ps.setString(2, "123456");
			// 可以使用setObject方法处理参数
			// ps.setObject();
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
