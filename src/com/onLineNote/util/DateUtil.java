package com.onLineNote.util;

import java.text.SimpleDateFormat;

public class DateUtil {
	
	public boolean isValdate(String format,String node)
	{
		boolean convertSuccess=true;
		
		SimpleDateFormat local_format = new SimpleDateFormat(format);
		try{
			local_format.setLenient(false);
			local_format.parse(node);
		}catch(Exception e)
		{
			convertSuccess = false;
		}
		return convertSuccess;
		
	}

}
