package com.onLineNote.util;

public class StringUtil {
	
	/**
	 * ÅÐ¶ÏÊÇ·ñÎª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str)
	{
		boolean rs = false;
		if(str == null ||"".equals(str.trim()))
		{
			rs = true;
		}
		return rs;
	}
	
	/**
	 * htmlÌØÊâ×Ö·û
	 * @param contentC
	 * @return
	 */
	public static String getHTMLWithString(String contentC) {
		String content = contentC;
		if (content == null) {
			return "";
		}
		content = content.replaceAll("&amp;", "&");
		content = content.replaceAll("&lt;", "<");
		content = content.replaceAll("&gt;", ">");
		content = content.replaceAll("&quot;", "\"");
		content = content.replaceAll("\r&#10;", "¡¡\n");
		content = content.replaceAll("&#10;", "¡¡\n");
		content = content.replaceAll("&#032;", " ");
		content = content.replaceAll("&#039;", "'");
		content = content.replaceAll("&#033;", "!");

		return content;
	}
	/**
	 * ×Ö·û´®ÌØÊâ×Ö·û×ª»»
	 * @param contentC
	 * @return
	 */
	public static String getStringWithHTML(String contentC) {
		String content = contentC;
		if (content == null) {
			return "";
		}
		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\"", "&quot;");
		content = content.replaceAll("\n\r", "&#10;");
		content = content.replaceAll("\r\n", "&#10;");
		content = content.replaceAll("\n", "&#10;");
		content = content.replaceAll(" ", "&#032;");
		content = content.replaceAll("'", "&#039;");
		content = content.replaceAll("!", "&#033;");

		return content;
	}
	
	/**
	 * 
	 * @param contentC
	 * @return
	 */
	public static String getSingleTran(String contentC)
	{
		String content = contentC;
		if (content == null) {
			return "";
		}
		content = content.replaceAll("'", "&#039;");
		
		return content;	
	}


}
