package com.onLineNote.Filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageFilter implements Filter {
	
	String[] ignorePage;

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletResponse response 	= (HttpServletResponse)arg1;
        HttpServletRequest  request 	= (HttpServletRequest)arg0;
        String requestURI 				= request.getRequestURI();
        //增加编码格式设置
        request.setCharacterEncoding("UTF-8");
        //增加忽略页面集合
        boolean flag = false;
        for(int i=0;i<ignorePage.length;i++)
        {
        	if(requestURI.equalsIgnoreCase(request.getContextPath()+ignorePage[i])||requestURI.equalsIgnoreCase(request.getContextPath()+"/"))
        	{
        		flag = true;
        		break;
        	}
        }
        //忽略页面不经过过滤器处理，直接返回
        if(flag)
        {
        	arg2.doFilter(request, response);
        	return;
        }else{
        	HttpSession session = request.getSession(false);
        	if(session == null){
        		request.setAttribute("errormsg","登陆超时");
        		request.getRequestDispatcher("/error.jsp").forward(request,response);	
        	}else{
        		String userid = (String)session.getAttribute("userinfo");
        		if(userid==null)
        		{
        			request.setAttribute("errormsg","登陆超时");
            		request.getRequestDispatcher("/error.jsp").forward(request,response);
        		}else{
        			arg2.doFilter(request, response);
                	return;
        		}
        	}
        }		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ignorePage = arg0.getInitParameter("ignorePage").split(",");
	}

}
