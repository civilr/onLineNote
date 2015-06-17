package com.onLineNote.dao.common;

import java.util.List;

import com.onLineNote.pojo.right.TNoteEnum;

public interface EnumDao {
	
	public List<TNoteEnum> getEnum(String enumfield);

}
