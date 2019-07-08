package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的查询
 * 
 * ResultSet对象是基于指针进行数据存储的，类似枚举。不便于数据的针对性的获取。可将数据转换到ArrayList中进行存储。
 * @author shangyang
 *
 */
public class TestSelect {

	public static void main(String[] args){
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
			String sql = "select * from user";
			// 5.指定sql命令
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString("username") + "  " + rs.getString(3));
			}
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
