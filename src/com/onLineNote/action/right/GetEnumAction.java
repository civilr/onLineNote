package com.onLineNote.action.right;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.onLineNote.service.common.EnumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetEnumAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EnumService enumService;
	
	private String enumfield = "";
	
	public EnumService getEnumService() {
		return enumService;
	}

	public void setEnumService(EnumService enumService) {
		this.enumService = enumService;
	}

	public String getEnumfield() {
		return enumfield;
	}

	public void setEnumfield(String enumfield) {
		this.enumfield = enumfield;
	}

	public String execute()
	{
		String josonStr = enumService.getJsonEnum(this.getEnumfield());
		
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(josonStr);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//…Ë÷√joson∑µªÿ÷µend
		return null;
	}

}
