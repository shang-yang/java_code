package com.shangyang.xml;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TestXML {

	public static void main(String[] args) throws Exception {
		//writerXML();
		readerXML();
	}

	/**
	 * 通过DOM4J解析生成xml文件
	 * @author shangyang
	 * @throws Exception
	 */
	public static void writerXML() throws Exception {
		// 1、通过DocumentHelper生成一个Document对象
		Document doc = DocumentHelper.createDocument();
		// 2、添加并得到根元素
		Element root = doc.addElement("sources");
		// 3、为根元素添加子元素
		Element student = root.addElement("student");
		// 4、为student元素添加属性
		student.addAttribute("id", "1614010101");
		// 5、为student添加子元素
		Element name = student.addElement("name");
		Element course = student.addElement("course");
		Element results = student.addElement("results");
		// 6、为子元素添加文本
		name.addText("张三");
		course.addText("数据结构");
		results.addText("67");
		// 7、将doc输出到xml文件中
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File("src/sources.xml")), format);
		writer.write(doc);
		writer.close();
	}

	/**
	 * 借助DOM4J解析读取XML文件内容
	 * 
	 * @author shangyang
	 * @throws Exception
	 */
	public static void readerXML() throws Exception {

		// 创建SAXReader对象，用于读取xml
		SAXReader reader = new SAXReader();
		// 读取xml文件，得到Document对象
		Document doc = reader.read(new File("src/book.xml"));
		// 获取根元素
		Element root = doc.getRootElement();
		// 获取根元素下所有子元素
		Iterator<Element> it = root.elementIterator();
		while (it.hasNext()) {
			// 取出元素
			Element e = it.next();
			// 获取id属性
			Attribute id = e.attribute("id");
			System.out.println(e.getName() + id.getValue());
			// 获取子元素
			Element name = e.element("name");
			Element author = e.element("author");
			Element price = e.element("price");

			System.out.println(name.getName() + " = " + name.getStringValue());
			System.out.println(author.getName() + " = " + author.getStringValue());
			System.out.println(price.getName() + " = " + price.getText());
			System.out.println("--------------");
		}
	}
}
