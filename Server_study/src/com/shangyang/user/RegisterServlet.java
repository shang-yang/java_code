package com.shangyang.user;

import com.shangyang.server.Request;
import com.shangyang.server.Response;
import com.shangyang.server.Servlet;

public class RegisterServlet implements Servlet{

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
	
		//关注业务逻辑
		String uname = request.getParameters("uname");
		String[] favs =request.getParameterValues("fav");	
		response.print("<html>"); 
		response.print("<head>"); 
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" ); 
		response.print("<title>");
		response.print("注册成功");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.println("你注册的信息为:"+uname);
		response.println("你喜欢的类型为:");
		for(String v:favs) {
			if(v.equals("0")) {
				response.print("萝莉型");
			}else if(v.equals("1")) {
				response.print("豪放型");
			}else if(v.equals("2")) {
				response.print("经济节约型");
			}
		}
		response.print("</body>");
		response.print("</html>");
	}
}
