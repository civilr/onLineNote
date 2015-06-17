package com.onLineNote.pojo.right;

/**
 * TNoteEnum entity. @author MyEclipse Persistence Tools
 */

public class TNoteEnum implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String enumid;
	private String enumfield;
	private String enumvalue;
	private Integer showorder;

	// Constructors

	/** default constructor */
	public TNoteEnum() {
	}

	/** full constructor */
	public TNoteEnum(String enumid, String enumfield, String enumvalue,
			Integer showorder) {
		this.enumid = enumid;
		this.enumfield = enumfield;
		this.enumvalue = enumvalue;
		this.showorder = showorder;
	}

	// Property accessors

	public String getEnumid() {
		return this.enumid;
	}

	public void setEnumid(String enumid) {
		this.enumid = enumid;
	}

	public String getEnumfield() {
		return this.enumfield;
	}

	public void setEnumfield(String enumfield) {
		this.enumfield = enumfield;
	}

	public String getEnumvalue() {
		return this.enumvalue;
	}

	public void setEnumvalue(String enumvalue) {
		this.enumvalue = enumvalue;
	}

	public Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(Integer showorder) {
		this.showorder = showorder;
	}

}