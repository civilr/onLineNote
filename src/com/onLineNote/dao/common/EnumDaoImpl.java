package com.onLineNote.dao.common;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.onLineNote.pojo.right.TNoteEnum;

public class EnumDaoImpl extends HibernateDaoSupport implements EnumDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TNoteEnum> getEnum(String enumfield) {
		List<TNoteEnum> list = getSession().createQuery(" from TNoteEnum where enumfield=:enumfield order by showorder").setString("enumfield", enumfield).list();
		return list;
	}

}
