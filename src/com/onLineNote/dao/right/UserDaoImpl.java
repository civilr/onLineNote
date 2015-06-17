package com.onLineNote.dao.right;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.onLineNote.pojo.right.TNoteUser;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public TNoteUser getUser(TNoteUser user) {
		
		TNoteUser tNoteUser = (TNoteUser)this.getHibernateTemplate().get(com.onLineNote.pojo.right.TNoteUser.class, user.getUserid());
		
		return tNoteUser;
	}

}
