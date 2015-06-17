package com.onLineNote.action.right;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.onLineNote.service.common.NoteInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetTreeInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String node;
	
	private String type;

	private String param;
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	NoteInfoService noteInfoService;
	
	
	public NoteInfoService getNoteInfoService() {
		return noteInfoService;
	}


	public void setNoteInfoService(NoteInfoService noteInfoService) {
		this.noteInfoService = noteInfoService;
	}


	public String getNode() {
		return node;
	}


	public void setNode(String node) {
		this.node = node;
	}
	
	
	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	public String execute()
	{	

		String content =noteInfoService.getNodeTreeInfo(this.getNode());
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getNoteInfo()
	{
	
		String content =noteInfoService.getNodeInfoById(this.getNode()) ;
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
		
	}
	
	public String getNodeInfoByContent()
	{
	
		String content = noteInfoService.getNoteInfoByMainContent(this.getParam());
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
		
	}

}
