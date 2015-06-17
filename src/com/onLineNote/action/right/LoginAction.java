package com.onLineNote.action.right;

import java.util.Map;

import com.onLineNote.service.right.RightService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -662611050658909035L;
	
	RightService rightService;
	
	private String userid;
	
	private String password;
	
	private String errormsg;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RightService getRightService() {
		return rightService;
	}

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}
	
	public String execute()
	{
		if(rightService.canLogin(this.getUserid(),this.getPassword()))
		{
			Map<String,Object> session= ActionContext.getContext().getSession();
			session.put("userinfo", this.getUserid());
			return "suc";
		}else{
			this.setErrormsg("µÇÂ½Ê§°ÜÁË£¡£¡");
			return "fal";
		}
		
	}

}
