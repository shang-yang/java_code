package com.shangyang.po;

import java.sql.*;
import java.util.*;

public class Knowledge {

	private Double knowledge_indicators;
	private Double knowledge_power;
	private Integer chapter_id;
	private Integer knowledge_id;
	private String knowledge_name;


	public Double getKnowledge_indicators() {
		return knowledge_indicators;
	}
	public Double getKnowledge_power() {
		return knowledge_power;
	}
	public Integer getChapter_id() {
		return chapter_id;
	}
	public Integer getKnowledge_id() {
		return knowledge_id;
	}
	public String getKnowledge_name() {
		return knowledge_name;
	}
	public void setKnowledge_indicators(Double knowledge_indicators){
		this.knowledge_indicators = knowledge_indicators;
	}
	public void setKnowledge_power(Double knowledge_power){
		this.knowledge_power = knowledge_power;
	}
	public void setChapter_id(Integer chapter_id){
		this.chapter_id = chapter_id;
	}
	public void setKnowledge_id(Integer knowledge_id){
		this.knowledge_id = knowledge_id;
	}
	public void setKnowledge_name(String knowledge_name){
		this.knowledge_name = knowledge_name;
	}
}
