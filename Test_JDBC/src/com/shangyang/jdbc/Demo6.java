package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试事务的基本概念和用法
 * @author shangyang
 *
 */
public class Demo6 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		try {
			// 加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 建立连接（连接对象内容其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			// 真正开发中，为了提高效率，都会使用连接池来管理连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			
			conn.setAutoCommit(false);	//JDBC中默认true自动提交事务
			
			String sql = "insert into user (username,password) values0 (?,?)";	// ?占位符
			ps1 = conn.prepareStatement(sql);
			ps1.setObject(1, "商鞅");
			ps1.setString(2, "qwerdf");
			ps1.execute();
			
			String sql2 = "insert into user (username,password) values0 (?,?,?)";	// ?占位符
			ps2 = conn.prepareStatement(sql);
			ps2.setObject(1, "商鞅");
			ps2.setString(2, "qwerdf");
			ps2.execute();
			
			
			
			
			conn.commit();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();	//回滚
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(ps1 != null) {
				try {
					ps1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps2 != null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
