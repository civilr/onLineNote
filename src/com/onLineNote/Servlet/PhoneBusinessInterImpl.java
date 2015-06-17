package com.onLineNote.Servlet;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.onLineNote.dao.common.NoteInfoDao;
import com.onLineNote.pojo.right.TNoteInfo;

public class PhoneBusinessInterImpl implements PhoneBusinessInter {
	
	NoteInfoDao noteInfoDao;

	public NoteInfoDao getNoteInfoDao() {
		return noteInfoDao;
	}

	public void setNoteInfoDao(NoteInfoDao noteInfoDao) {
		this.noteInfoDao = noteInfoDao;
	}

	@Override
	public ReturnMessage getNoteJsonInfo(String paramter) {
		
		ReturnMessage rm = new ReturnMessage();
		
		List<TNoteInfo> list = noteInfoDao.getNoteJsonInfo(paramter);
		
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		
		for(int i=0;i<list.size();i++)
		{
			TNoteInfo tNoteInfo = list.get(i);
			jo.put("note_id", tNoteInfo.getNoteId());
			jo.put("note_kind", tNoteInfo.getNoteKind());
			jo.put("note_label", tNoteInfo.getNoteLabel());
			jo.put("note_content", tNoteInfo.getNoteContent());
			jo.put("note_title", tNoteInfo.getNoteTitle());
			jo.put("note_remark", tNoteInfo.getNoteRemark());
			jo.put("note_date", tNoteInfo.getNoteDate());
			ja.add(jo);
		}
		rm.setReturn_flag("0");
		rm.setReturn_msg(ja.toString());
		
		return rm;
	}

}
