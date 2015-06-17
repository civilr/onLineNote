package com.onLineNote.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import net.sf.json.JSONObject;

public class PhoneServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PhoneBusinessInter phoneBusinessInter;

	public PhoneBusinessInter getPhoneBusinessInter() {
		return phoneBusinessInter;
	}

	public void setPhoneBusinessInter(PhoneBusinessInter phoneBusinessInter) {
		this.phoneBusinessInter = phoneBusinessInter;
	}
	
	
	public void init()throws ServletException{
		super.init();
		ServletContext servletContext = this .getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		phoneBusinessInter = (PhoneBusinessInter) ctx.getBean("phoneBusinessInter" ); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		System.out.println("start request....");
		
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String  callback = request.getParameter("callback");
		PrintWriter out = response.getWriter();
		JSONObject jsresult = new JSONObject();
		String method = request.getParameter("method");
		String para_matter = request.getParameter("para_matter");
		
		try{
			
			Method auc = phoneBusinessInter.getClass().getMethod(method, String.class);
			
			ReturnMessage rs = (ReturnMessage) auc.invoke(phoneBusinessInter, para_matter);
			
			jsresult.put("return_flag", rs.getReturn_flag());
			
			jsresult.put("return_msg", rs.getReturn_msg());
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
            jsresult.put("return_flag", "9999");
			
			jsresult.put("return_msg", e.getMessage());
		}
		
		out.print(callback+"("+jsresult+")");
		out.flush();
		out.close();
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

}
