package com.onLineNote.dao.common;

import java.util.List;

import com.onLineNote.pojo.right.TNoteInfo;

public interface NoteInfoDao {
	
	public void insertNoteInfo(TNoteInfo tNoteInfo);
	
	public List<String> getTNoteInfo(String dateFormat,String condition);
	
	public List<TNoteInfo> getTNoteInfoEntity(String year,String month);
	
	public TNoteInfo getTNoteInfoEntityById(String noteId);
	
	public void updateNoteInfo(TNoteInfo tNoteInfo);
	
	public List<TNoteInfo> getTNoteInfoByMainContent(String keyword);
	
	public List<TNoteInfo> getNoteJsonInfo(String date);

}
