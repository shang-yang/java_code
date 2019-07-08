package com.shangyang.test;

import java.util.List;

import com.shangyang.po.Emp;
import com.shangyang.sorm.core.Query;
import com.shangyang.sorm.core.QueryFactory;

/**
 * 客户端调用的测试类
 * @author shangyang
 *
 */
public class Test {

	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
		List<Emp> list = q.queryRows("select * from emp where id>?", Emp.class, new Object[] {2});
		for(Emp emp:list) {
			System.out.println(emp.getRealname());
		}
	}
}
