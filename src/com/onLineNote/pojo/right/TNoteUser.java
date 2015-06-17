package com.onLineNote.pojo.right;



/**
 * TNoteUser entity. @author MyEclipse Persistence Tools
 */

public class TNoteUser  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -3492178083447895177L;
	private String userid;
     private String password;


    // Constructors

    /** default constructor */
    public TNoteUser() {
    }

    
    /** full constructor */
    public TNoteUser(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

   
    // Property accessors

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}