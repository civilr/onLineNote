package com.onLineNote.dao.common;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.onLineNote.pojo.right.TNoteInfo;

public class NoteInfoDaoImpl extends HibernateDaoSupport implements NoteInfoDao {

	@Override
	public void insertNoteInfo(TNoteInfo tNoteInfo) {
		try{
			getSession().save(tNoteInfo);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTNoteInfo(String dateFormat,String condition) {
		
		List<String> list = null;
		
		if(!"".equals(condition))
		{
			list = getSession().createQuery("select distinct date_format(noteDate, '"+dateFormat+"') as noteDate from TNoteInfo where date_format(noteDate, '%Y')=:condition order by noteDate desc ").setString("condition", condition).list();
		}else{
			list = getSession().createQuery("select distinct date_format(noteDate, '"+dateFormat+"') as noteDate from TNoteInfo order by noteDate desc").list();
		}
		
		
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TNoteInfo> getTNoteInfoEntity(String year, String month) {
		
		List<TNoteInfo> list = getSession().createQuery("from TNoteInfo where  date_format(noteDate, '%Y')=:year and date_format(noteDate, '%m')=:month order by noteDate desc").setString("year", year).setString("month", month).list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TNoteInfo getTNoteInfoEntityById(String noteId) {
		TNoteInfo tNoteInfo = new TNoteInfo();
		try
		{
			List<TNoteInfo> list=getSession().createQuery("from TNoteInfo where noteId=:noteId").setInteger("noteId", new Integer(noteId)).list();
			if(list.size()>0)
			{
				tNoteInfo = list.get(0);
			}
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}
		
		return tNoteInfo;
	}

	@Override
	public void updateNoteInfo(TNoteInfo tNoteInfo) {
		getSession().update(tNoteInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TNoteInfo> getTNoteInfoByMainContent(String keyword) {
		List<TNoteInfo> list = getSession().createQuery("from TNoteInfo where noteContent like '%"+keyword+"%' order by noteDate desc").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TNoteInfo> getNoteJsonInfo(String date) {
		
		List<TNoteInfo> list = getSession().createQuery("from TNoteInfo where date_format(noteDate, '%Y%m%d')=:date order by noteDate desc").setString("date", date).list();
		
		return list;
	}

}
