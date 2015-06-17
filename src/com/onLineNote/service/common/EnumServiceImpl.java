package com.onLineNote.service.common;

import java.util.List;

import com.onLineNote.dao.common.EnumDao;
import com.onLineNote.pojo.right.TNoteEnum;


public class EnumServiceImpl implements EnumService {
	
	EnumDao enumDao;

	public EnumDao getEnumDao() {
		return enumDao;
	}

	public void setEnumDao(EnumDao enumDao) {
		this.enumDao = enumDao;
	}

	@Override
	public String getJsonEnum(String enumfield) {
		
		List<TNoteEnum> list = enumDao.getEnum(enumfield);
		
        StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		
		for(int i=0;i<list.size();i++)
		{
			TNoteEnum tNoteEnum = list.get(i);
			sb.append("[");
			sb.append("'"+tNoteEnum.getEnumid()+"'");
			sb.append(",");
			sb.append("'"+tNoteEnum.getEnumvalue()+"'");
			sb.append("]");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		
		
		return sb.toString();
	}

}
