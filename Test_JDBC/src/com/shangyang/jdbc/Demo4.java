package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试ResultSet结果集的基本用法
 * @author shangyang
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 建立连接（连接对象内容其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			// 真正开发中，为了提高效率，都会使用连接池来管理连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			
			String sql = "select * from user where id>?";	// ?占位符
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 2);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getString(3));
			}
			
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
			if(ps != null) {
				try {
					ps.close();
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
