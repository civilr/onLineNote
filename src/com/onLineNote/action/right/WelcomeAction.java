package com.onLineNote.action.right;


import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9135120434969444681L;
	
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String execute()
	{
		Map<String,Object> session= ActionContext.getContext().getSession();
		this.setUserid((String)session.get("userinfo"));
		return "suc";
	}
}