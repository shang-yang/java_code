package com.shangyang.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private Integer user_id;
	private Integer id;
	private String email;
	private String realname;


	public Integer getUser_id() {
		return user_id;
	}
	public Integer getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getRealname() {
		return realname;
	}
	public void setUser_id(Integer user_id){
		this.user_id = user_id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setRealname(String realname){
		this.realname = realname;
	}
}
