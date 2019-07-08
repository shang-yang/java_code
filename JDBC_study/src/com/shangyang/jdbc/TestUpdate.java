package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) {
		// 声明jdbc变量
		Connection conn = null;
		Statement stmt = null;

		// 声明jdbc参数
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "123456";

		try {
			// 1 加载驱动类
			Class.forName(driver);

			// 2.获取数据库连接对象（连接指定数据库）
			conn = DriverManager.getConnection(url, user, password);

			// 3.创建sql命令对象(编译和发送sql命令给数据库)
			stmt = conn.createStatement();

			// 4.创建sql命令
			String sql = "update user set username='王update' where id=13";

			// 5.指定sql命令
			int i = stmt.executeUpdate(sql);
			System.out.println("执行结果：" + i);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
