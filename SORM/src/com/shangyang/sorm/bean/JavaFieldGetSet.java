package com.shangyang.sorm.bean;

/**
 * 封装了java属性和get、set方法的源代码
 * @author shangyang
 *
 */
public class JavaFieldGetSet {

	/**
	 * 属性的源码信息。如：private int userId;
	 */
	private String fiedInfo;
	/**
	 * get方法的源码信息，如：public int getUserId(){}
	 */
	private String getInfo;
	/**
	 * set方法的源码信息，如：public void setUserId(int id){this.id=id;}
	 */
	private String setInfo;
	
	
	public JavaFieldGetSet() {
		super();
	}
	
	public JavaFieldGetSet(String fiedInfo, String getInfo, String setInfo) {
		super();
		this.fiedInfo = fiedInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	
	
	public String getFiedInfo() {
		return fiedInfo;
	}
	public void setFiedInfo(String fiedInfo) {
		this.fiedInfo = fiedInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	
	
	
}
