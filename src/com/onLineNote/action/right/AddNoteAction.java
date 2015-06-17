package com.onLineNote.action.right;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.onLineNote.service.common.NoteInfoService;
import com.onLineNote.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddNoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String note_id;

	private String note_date;
	
	private String note_kind;
	
	private String note_label;
	
	private String note_title;
	
	private String note_content;
	
	private String note_remark;
	
	NoteInfoService noteInfoService;
	

	
	public NoteInfoService getNoteInfoService() {
		return noteInfoService;
	}



	public void setNoteInfoService(NoteInfoService noteInfoService) {
		this.noteInfoService = noteInfoService;
	}



	public String getNote_date() {
		return note_date;
	}



	public void setNote_date(String noteDate) {
		note_date = noteDate;
	}



	public String getNote_kind() {
		return note_kind;
	}



	public void setNote_kind(String noteKind) {
		note_kind = noteKind;
	}



	public String getNote_label() {
		return note_label;
	}



	public void setNote_label(String noteLabel) {
		note_label = noteLabel;
	}



	public String getNote_title() {
		return note_title;
	}



	public void setNote_title(String noteTitle) {
		note_title = noteTitle;
	}



	public String getNote_content() {
		return note_content;
	}



	public void setNote_content(String noteContent) {
		note_content = noteContent;
	}



	public String getNote_remark() {
		return note_remark;
	}



	public void setNote_remark(String noteRemark) {
		note_remark = noteRemark;
	}
	
	public String getNote_id() {
		return note_id;
	}



	public void setNote_id(String noteId) {
		note_id = noteId;
	}




	public String execute(){
		//判断新增还是修改
		if(StringUtil.isNull(this.getNote_id()))
		{
			noteInfoService.insertNoteInfo(this.getNote_date(), this.getNote_kind(), this.getNote_label(), this.getNote_title(), this.getNote_content(), this.getNote_remark());
		}else{
			noteInfoService.updateNoteInfo(this.getNote_id(), this.getNote_date(), this.getNote_kind(), this.getNote_label(), this.getNote_title(), this.getNote_content(), this.getNote_remark());
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("处理成功");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
