package com.shangyang.test.annotation;

@SyAnnotation01("tb_student")
public class SyStudent {

	@SyField(columnName="id",type="int",length=10)
	private int id;
	
	@SyField(columnName="sname",type="varchar",length=10)
	private String sname;
	
	@SyField(columnName="age",type="int",length=3)
	private int age;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
