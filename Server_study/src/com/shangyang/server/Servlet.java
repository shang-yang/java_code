package com.shangyang.server;

/**
 * 服务器小脚本接口
 * @author shangyang
 *
 */
public interface Servlet {
	void service(Request request,Response response);
}
