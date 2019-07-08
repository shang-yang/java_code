package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class preTest {

	public static void main(String[] args){
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		// 声明jdbc参数
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "123456";
		try {
			//  加载驱动类
			Class.forName(driver);
			// 获取数据库连接对象（连接指定数据库）
			conn = DriverManager.getConnection(url, user, password);
			// 创建sql命令
			String sql = "insert into user values(?,?,?)";
			// 创建sql命令对象(预编译)
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 15);
			ps.setString(2, "王15");
			ps.setString(3, "123456");
			// 执行sql命令
			int i = ps.executeUpdate();
			System.out.println("执行结果：" + i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
