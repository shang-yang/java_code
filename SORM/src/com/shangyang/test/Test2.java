package com.shangyang.test;

import java.util.List;

import com.shangyang.po.Emp;
import com.shangyang.sorm.core.Query;
import com.shangyang.sorm.core.QueryFactory;

/**
 * 测试连接池的效率
 * @author shangyang
 *
 */
public class Test2 {

	public static void test01() {
		Query q = QueryFactory.createQuery();
		List<Emp> list = q.queryRows("select * from emp where id>?", Emp.class, new Object[] {2});
		for(Emp emp:list) {
			//System.out.println(emp.getRealname() + "--" + emp.getEmail());
		}
	}
	
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		test01();
		long b = System.currentTimeMillis();
		System.out.println((b-a));	//524
	}
}
