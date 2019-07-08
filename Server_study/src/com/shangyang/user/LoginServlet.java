package com.shangyang.user;

import com.shangyang.server.Request;
import com.shangyang.server.Response;
import com.shangyang.server.Servlet;

public class LoginServlet implements Servlet{

	@Override
	public void service(Request request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<meta charset=\"utf-8\">");
		response.print("<title>");
		response.print("<第一个servlet>");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("欢迎回来：" + request.getParameters("uname"));
		response.print("</body>");
		response.print("</html>");
	}
}
