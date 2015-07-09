package com.onLineNote.dao.project;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.onLineNote.pojo.project.TProjectUser;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	@Override
	public void saveProjectUser(TProjectUser tProjectUser) {
		// TODO Auto-generated method stub
		try{
			getSession().save(tProjectUser);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
