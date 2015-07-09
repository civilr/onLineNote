package com.onLineNote.pojo.project;

/**
 * TProjectUser entity. @author MyEclipse Persistence Tools
 */

public class TProjectUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String email;
	private String userName;
	private String userPwd;
	private String userRole;

	// Constructors

	/** default constructor */
	public TProjectUser() {
	}

	/** full constructor */
	public TProjectUser(String userId, String email, String userName,
			String userPwd, String userRole) {
		this.userId = userId;
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRole = userRole;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}