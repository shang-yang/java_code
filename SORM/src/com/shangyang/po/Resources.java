package com.shangyang.po;

import java.sql.*;
import java.util.*;

public class Resources {

	private Integer resources_id;
	private String resources_url;
	private String resources_type;
	private Integer knowledge_id;
	private String resources_name;
	private java.sql.Date resources_date;


	public Integer getResources_id() {
		return resources_id;
	}
	public String getResources_url() {
		return resources_url;
	}
	public String getResources_type() {
		return resources_type;
	}
	public Integer getKnowledge_id() {
		return knowledge_id;
	}
	public String getResources_name() {
		return resources_name;
	}
	public java.sql.Date getResources_date() {
		return resources_date;
	}
	public void setResources_id(Integer resources_id){
		this.resources_id = resources_id;
	}
	public void setResources_url(String resources_url){
		this.resources_url = resources_url;
	}
	public void setResources_type(String resources_type){
		this.resources_type = resources_type;
	}
	public void setKnowledge_id(Integer knowledge_id){
		this.knowledge_id = knowledge_id;
	}
	public void setResources_name(String resources_name){
		this.resources_name = resources_name;
	}
	public void setResources_date(java.sql.Date resources_date){
		this.resources_date = resources_date;
	}
}
