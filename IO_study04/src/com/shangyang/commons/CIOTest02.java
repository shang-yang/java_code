package com.shangyang.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 列出子孙集
 * @author shangyang
 *
 */
public class CIOTest02 {

	public static void main(String[] args) {
		Collection<File> files = FileUtils.listFiles(new File("/home/shangyang/桌面/a"), EmptyFileFilter.NOT_EMPTY, null);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("*************************************");
		files = FileUtils.listFiles(new File("/home/shangyang/桌面/黑马Python"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("*************************************");
		files = FileUtils.listFiles(new File("/home/shangyang/桌面/黑马Python"), new SuffixFileFilter("py"), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("*************************************");
		files = FileUtils.listFiles(new File("/home/shangyang/桌面/黑马Python"), FileFilterUtils.or(new SuffixFileFilter("py"),new SuffixFileFilter("xml"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
