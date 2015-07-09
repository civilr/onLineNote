package com.onLineNote.service.project;

import com.onLineNote.dao.project.ProjectDao;
import com.onLineNote.pojo.project.TProjectUser;
import com.onLineNote.util.Md5Util;

public class ProjectServiceImpl implements ProjectService {
	
	ProjectDao projectDao;

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public void saveProjectUser(String userId, String userName, String email,
			String userPwd) {
		// TODO Auto-generated method stub
		
		TProjectUser tProjectUser = new TProjectUser();
		
		tProjectUser.setUserId(userId);
		
		tProjectUser.setUserName(userName);
		
		tProjectUser.setEmail(email);
		
		tProjectUser.setUserPwd(Md5Util.md5s(userPwd));
		
		tProjectUser.setUserRole("0");
		
		projectDao.saveProjectUser(tProjectUser);
		
	}

}
