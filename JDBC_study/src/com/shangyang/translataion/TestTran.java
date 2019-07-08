package com.shangyang.translataion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的事务管理
 * 		转帐业务
 * 注意：
 * 		JDBC中的事务是自动提交的
 * 
 * 	设置JDBC的事务为手动提交，只要SQL语句都执行成功后再统一提交，只要有失败就回滚。
 * @author shangyang
 *
 */
public class TestTran {
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

			// 设置事务为手动提交
			conn.setAutoCommit(false);
			// 3.创建sql命令对象(编译和发送sql命令给数据库)
			stmt = conn.createStatement();

			// 4.创建sql命令
			String sql1 = "update user set passwoed='zhang0' where id=8";
			String sql2 = "update user set passwoed='zhang1' where id=9";

			// 5.指定sql命令
			int i1 = stmt.executeUpdate(sql1);
			int i2= stmt.executeUpdate(sql2);
			System.out.println("执行结果：" +  i1);
			System.out.println("执行结果：" +  i2);
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
