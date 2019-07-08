package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理的基本用法
 * @author shangyang
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 建立连接（连接对象内容其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			// 真正开发中，为了提高效率，都会使用连接池来管理连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			
			conn.setAutoCommit(false);	// 设为手动提交
			
			stmt = conn.createStatement();
			
			for(int i = 0; i < 5; i ++) {
				stmt.addBatch("insert into user (username,password) values ('zhang" + i + "','123123')");
			}
			
			stmt.executeBatch();
			conn.commit(); 	// 提交事务
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
