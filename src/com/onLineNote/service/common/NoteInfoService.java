package com.onLineNote.service.common;

public interface NoteInfoService {
	
	public void insertNoteInfo(String note_date,String note_kind,String note_label,String note_title,String note_content,String note_remark);

	public String getNodeTreeInfo(String nodeId);
	
	public String getNodeInfoById(String nodeId);
	
	public void updateNoteInfo(String note_id,String note_date,String note_kind,String note_label,String note_title,String note_content,String note_remark);
	
	public String getNoteInfoByMainContent(String keyword);
}
