package com.shangyang.sorm.core;


/**
 * 负责针对Mysql数据库的查询
 * @author shangyang
 *
 */
public class MySqlQuery extends Query{

	
//	public static void main(String[] args) {
//		Emp e = new Emp();
//		e.setId(2);
//		e.setUser_id(10);
//		e.setRealname("张三改");
//		e.setEmail("zhangsan@qq.com");
//		//new MySqlQuery().delete(e);
//		//new MySqlQuery().insert(e);
//		//new MySqlQuery().update(e,new String[]{"user_id","realname"});
//		List<Emp> list = new MySqlQuery().queryRows("select * from emp where id>?", Emp.class, new Object[] {2});
//		for(Emp emp:list) {
//			System.out.println(emp.getRealname());
//		}
//	}

	
	
	
	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
