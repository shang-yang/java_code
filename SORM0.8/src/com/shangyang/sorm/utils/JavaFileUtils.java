package com.shangyang.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shangyang.sorm.bean.ColumnInfo;
import com.shangyang.sorm.bean.JavaFieldGetSet;
import com.shangyang.sorm.bean.TableInfo;
import com.shangyang.sorm.core.DBManager;
import com.shangyang.sorm.core.MySqlTypeConvertor;
import com.shangyang.sorm.core.TableContext;
import com.shangyang.sorm.core.TypeConvertor;

/**
 * 封装了生成java文件（源代码）常用的操作
 * @author shangyang
 *
 */
public class JavaFileUtils {

	/**
	 * 根据字段信息生成java属性信息。如var username -- private String username;以及相应的set和get方法源码
	 * @param column 字段信息
	 * @param convertor 类型转化器
	 * @return java属性和set/get方法源码
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor) {
		
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		
		String javaFieldType = convertor.databaseType2JavaType(column.getDateType());
		
		jfgs.setFiedInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");
		
		//public String getUsername(){return username;}
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "() {\n");
		getSrc.append("\t\treturn " + column.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username=username;}
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
		setSrc.append(javaFieldType + " " + column.getName() + "){\n");
		setSrc.append("\t\tthis." + column.getName() + " = " + column.getName() + ";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		
		return jfgs;
	}
	
	
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器
	 * @return java类的源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor) {
		
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for(ColumnInfo c:columns.values()) {
			javaFields.add(createFieldGetSetSRC(c,convertor));
		}
		
		StringBuilder src = new StringBuilder();
		
		//生成package语句
		src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");
		//生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//生成类声明语句
		src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n\n");
		
		//生成属性类表
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getFiedInfo());
		}
		src.append("\n\n");
		//生成get方法类表
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getGetInfo());
		}
		
		//生成set方法类表
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getSetInfo());
		}
		//生成结束符
		src.append("}\n");
		return src.toString();
	}
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo,convertor);
		
		String srcPath = DBManager.getConf().getSrcPath() + "/";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		
		File f = new File(srcPath+packagePath);
		System.out.println(f.getAbsolutePath() + "*****************");
		
		if(!f.exists()) {	//如果指定目录不存在，则帮助用户建立
			f.mkdirs();
		}
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsolutePath() + "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
			bw.write(src);
			System.out.println("建立表" + tableInfo.getTname() + 
					"对应的java类：" + StringUtils.firstChar2UpperCase(tableInfo.getTname() + ".java"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		Map<String,TableInfo> map = TableContext.tables;
//		for(TableInfo t : map.values()) {
//			createJavaPOFile(t,new MySqlTypeConvertor());
//		}
//	}
	
}
