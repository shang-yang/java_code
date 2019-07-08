package com.shangyang.sorm.bean;

/**
 * 封装表中一个字段的信息
 * @author shangyang
 *
 */
public class ColumnInfo {

	/**
	 * 字段名称
	 */
	private String name;
	
	/**
	 * 字段的数据类型
	 */
	private String dateType;
	
	/**
	 * 字段的键类型（0:普通键，1:主键，2:外键）
	 */
	private int keyType;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public int getKeyType() {
		return keyType;
	}

	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}

	public ColumnInfo(String name, String dateType, int keyType) {
		super();
		this.name = name;
		this.dateType = dateType;
		this.keyType = keyType;
	}

	public ColumnInfo() {
		super();
	}
	
}
