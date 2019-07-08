package JUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	/**
	 * 封装DML
	 * @param sql	sql语句
	 * @param objs	参数数组
	 * @return i 大于等于 1 时执行成功，等于 0 时执行失败。
	 */
	private int executeDML(String sql,Object ... objs) {
		Connection conn = null;
		PreparedStatement ps = null;
		int i= 0;
		try {
			// 创建连接对象
			conn = JUtil.getConn();
			// 手动提交事物
			conn.setAutoCommit(false);
			// 获得sql语句及参数
			ps = JUtil.getPre(conn, sql);
			// 给占位符赋值
			for(int j = 0; j < objs.length; j++) {
				ps.setObject(j+1, objs[j]);
			}
			// 执行sql命令
			i = ps.executeUpdate();
			// 提交
			conn.commit();
		} catch (SQLException e) {
			try {
				// 回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JUtil.closeAll(ps, conn);
		}
		return i;
	}
	
	
	
	/**
	 * 增加
	 * @param id
	 * @param name
	 * @param pwd
	 * @return  i 大于等于 1 时执行成功，等于 0 时执行失败。
	 */
	public int insert(int id,String name,String pwd) {
		String sql = "insert into user values(?,?,?)";
		int i = executeDML(sql,id,name,pwd);
		return i;
	}
	
	/**
	 * 修改
	 * @param id
	 * @param name
	 * @param pwd
	 * @return  i 大于等于 1 时执行成功，等于 0 时执行失败。
	 */
	public int update(int id,String name,String pwd) {
		String sql = "update user set username=? where id=?";
		int i = executeDML(sql,name,id);
		return i;
	}
	
	/**
	 * 删除
	 * @param id
	 * @param name
	 * @param pwd
	 * @return  i 大于等于 1 时执行成功，等于 0 时执行失败。
	 */
	public int delete(int id,String name,String pwd) {
		String sql = "delete from user where id=?";
		int i = executeDML(sql, id);
		return i;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<User> select() {
		Connection conn = JUtil.getConn();
		String sql = "select * from user";
		PreparedStatement ps =  JUtil.getPre(conn, sql);
		List<User> us = new ArrayList<User>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPwd(rs.getString(3));
				us.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JUtil.closeAll(ps, conn);
		}
		return us;
	}
	
}
