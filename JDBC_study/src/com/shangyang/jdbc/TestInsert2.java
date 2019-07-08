package com.shangyang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 常见的jdbc错误：
 * 		a ClassNotFoundException:
 * 			驱动类未找到
 * 		b java.sql.SQLException: No suitable driver found for :mysql://localhost:3306/test
 * 			URL错误
 * 		c No database selected
 * 			未找到数据库
 * 		d Access denied for user 'root1'@'localhost' (using password: YES)
 * 			用户名或密码错误
 * 		e java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax;
 * 			sql语句错误
 * 		f java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '13' for key 'PRIMARY'
 * 			主键冲突
 * 		
 * @author shangyang
 *
 */
public class TestInsert2 {

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
			String sql = "insert into user values(13,'王13','wang13')";
			
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
