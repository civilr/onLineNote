package com.onLineNote.service.common;

import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONObject;

import com.onLineNote.dao.common.NoteInfoDao;
import com.onLineNote.pojo.right.TNoteInfo;

public class NoteInfoServieImpl implements NoteInfoService {
	
	NoteInfoDao noteInfoDao;

	public NoteInfoDao getNoteInfoDao() {
		return noteInfoDao;
	}

	public void setNoteInfoDao(NoteInfoDao noteInfoDao) {
		this.noteInfoDao = noteInfoDao;
	}

	@Override
	public void insertNoteInfo(String noteDate, String noteKind,
			String noteLabel, String noteTitle, String noteContent,
			String noteRemark) {
		TNoteInfo tNoteInfo = new TNoteInfo();
		tNoteInfo.setNoteDate(Timestamp.valueOf(noteDate));
		tNoteInfo.setNoteKind(noteKind);
		tNoteInfo.setNoteLabel(noteLabel);
		tNoteInfo.setNoteTitle(noteTitle);
		tNoteInfo.setNoteContent(noteContent);
		tNoteInfo.setNoteRemark(noteRemark);
		noteInfoDao.insertNoteInfo(tNoteInfo);
	}

	@Override
	public String getNodeTreeInfo(String nodeId) {
		
		List<String> list = null;
		 StringBuffer sb = new StringBuffer("");
		
		if("0".equals(nodeId))
		{
			list = noteInfoDao.getTNoteInfo("%Y","");
			//生成树信息
			   sb.append("[");
				
				for(int i=0;i<list.size();i++)
				{
					sb.append("{text:'"+list.get(i)+"',");
					sb.append("id:'year_"+list.get(i)+"',");
					sb.append("leaf:false}");
					sb.append(",");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("]");
		}else if(nodeId.indexOf("month")>=0)
		{
			List<TNoteInfo> listlocal = null;
			listlocal = noteInfoDao.getTNoteInfoEntity(nodeId.split("_")[1],nodeId.split("_")[3]);
			//生成树信息
			   sb.append("[");
				
				for(int i=0;i<listlocal.size();i++)
				{
					TNoteInfo tNoteInfo = listlocal.get(i);
					sb.append("{text:'"+tNoteInfo.getNoteTitle()+"',");
					sb.append("id:'"+tNoteInfo.getNoteId()+"',");
					sb.append("leaf:true}");
					sb.append(",");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("]");
		}
		else if(nodeId.indexOf("year")>=0)
		{
			list = noteInfoDao.getTNoteInfo("%m",nodeId.split("_")[1]);
			//生成树信息
			   sb.append("[");
				
				for(int i=0;i<list.size();i++)
				{
					sb.append("{text:'"+list.get(i)+"',");
					sb.append("id:'year_"+nodeId.split("_")[1]+"_month_"+list.get(i)+"',");
					sb.append("leaf:false}");
					sb.append(",");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("]");
		}
	
		return sb.toString();
	}

	@Override
	public String getNodeInfoById(String nodeId) {
		TNoteInfo tNoteInfo = noteInfoDao.getTNoteInfoEntityById(nodeId);
		
		//add start by yuzq 20150418 for 特殊字符串无法解析，改使用json对象方式进行返回
		JSONObject jobj = new JSONObject();
		jobj.put("note_id", tNoteInfo.getNoteId());
		jobj.put("note_date", tNoteInfo.getNoteDate().toString().substring(0, tNoteInfo.getNoteDate().toString().length()-2));
		jobj.put("note_kind", tNoteInfo.getNoteKind());
		jobj.put("note_label", tNoteInfo.getNoteLabel());
		jobj.put("note_title", tNoteInfo.getNoteTitle());
		jobj.put("note_content", tNoteInfo.getNoteContent());
		jobj.put("note_remark", tNoteInfo.getNoteRemark());
		//add end by yuzq 20150418 for 特殊字符串无法解析，改使用json对象方式进行返回
		
		/*StringBuffer sb = new StringBuffer("");
		sb.append("[{");
		sb.append("note_id:'"+tNoteInfo.getNoteId()+"',");
		sb.append("note_date:'"+tNoteInfo.getNoteDate().toString().substring(0, tNoteInfo.getNoteDate().toString().length()-2)+"',");
		sb.append("note_kind:'"+tNoteInfo.getNoteKind()+"',");
		sb.append("note_label:'"+tNoteInfo.getNoteLabel()+"',");
		sb.append("note_title:'"+tNoteInfo.getNoteTitle()+"',");
		sb.append("note_content:'"+StringUtil.getStringWithHTML(tNoteInfo.getNoteContent())+"',");
		sb.append("note_remark:'"+tNoteInfo.getNoteRemark()+"'");
		sb.append("}]");
		String rs=sb.toString();
		System.out.println(rs);*/
		String rs = "["+jobj.toString()+"]";
		return rs;
	}

	@Override
	public void updateNoteInfo(String noteId, String noteDate, String noteKind,
			String noteLabel, String noteTitle, String noteContent,
			String noteRemark) {
	
		TNoteInfo tNoteInfo = new TNoteInfo();
		tNoteInfo.setNoteId(new Integer(noteId));
		tNoteInfo.setNoteDate(Timestamp.valueOf(noteDate));
		tNoteInfo.setNoteKind(noteKind);
		tNoteInfo.setNoteLabel(noteLabel);
		tNoteInfo.setNoteTitle(noteTitle);
		tNoteInfo.setNoteContent(noteContent);
		tNoteInfo.setNoteRemark(noteRemark);
		noteInfoDao.updateNoteInfo(tNoteInfo);
	}

	@Override
	public String getNoteInfoByMainContent(String keyword) {
		List<TNoteInfo> list = noteInfoDao.getTNoteInfoByMainContent(keyword);
		StringBuffer sb = new StringBuffer("");
		sb.append("{");
		sb.append("\"rows\":");
		sb.append("[");
		for(int i=0;i<list.size();i++)
		{
			TNoteInfo tNoteInfo = list.get(i);
			sb.append("{");
			sb.append("\"note_id\":\""+tNoteInfo.getNoteId()+"\",");
			sb.append("\"note_title\":\""+tNoteInfo.getNoteTitle()+"\",");
			sb.append("\"note_label\":\""+tNoteInfo.getNoteLabel()+"\"");
			sb.append("},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		sb.append("}");
		System.out.println(sb.toString());
		return sb.toString();
	}


}
