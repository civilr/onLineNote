package com.onLineNote.action.right;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7557634988952586672L;
	
	public String execute()
	{
		Map<String,Object> session= ActionContext.getContext().getSession();
		
		if(session !=null)
		{
			session = null;
		}
		
		return "suc";
	}

}
