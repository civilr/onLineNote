package com.onLineNote.action.project;



import com.onLineNote.service.project.ProjectService;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {
	
	ProjectService projectService;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	private String user_id;

	private String user_name;
	
	private String email;
	
	private String user_pwd;
	
	private String errormsg;
	
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String userPwd) {
		user_pwd = userPwd;
	}

	/**
     * ע����ת
     */
	public String execute(){
		return "suc";
	}
	
	/**
	 * ע���ύ
	 * @return
	 */
	public String registSubmit(){
		try{
			projectService.saveProjectUser(user_id, user_name, email, user_pwd);
		}catch(Exception e)
		{
			e.printStackTrace();
			this.setErrormsg("ע��ʧ�ܣ��������ύ����");
			return "fal";
		}
		this.setErrormsg("ע��ɹ������¼����");
		return "suc";
	}
}
