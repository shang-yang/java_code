package com.shangyang.po;

import java.sql.*;
import java.util.*;

public class Task {

	private Integer id;
	private String title;
	private String status;


	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getStatus() {
		return status;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setStatus(String status){
		this.status = status;
	}
}
