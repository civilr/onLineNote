package com.onLineNote.service.right;

import com.onLineNote.dao.right.UserDao;
import com.onLineNote.pojo.right.TNoteUser;
import com.onLineNote.util.Md5Util;

public class RightServiceImpl implements RightService {
	
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean canLogin(String userid, String password) {
		
		TNoteUser tNoteUser = new TNoteUser();
		
		tNoteUser.setUserid(userid);
		
		TNoteUser tdbNoteUser = userDao.getUser(tNoteUser);
		
		if(tdbNoteUser!=null&&Md5Util.md5s(password).equals(tdbNoteUser.getPassword()))
		{
			return true;
		}
		return false;
		
	}



}
