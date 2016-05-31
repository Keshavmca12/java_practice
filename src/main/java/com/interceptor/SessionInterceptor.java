package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		System.out.println("requesturi"+request.getRequestURI());

		// Avoid a redirect loop for some urls
		if( request.getRequestURI().contains("resource"))
		{

		}else if(request.getRequestURI().contains("invalidSession")){
			//response.sendRedirect("/Test/invalidSession");
		}else if(request.getRequestURI().contains("login")){ 
			HttpSession session = request.getSession(true);//equivalent to request.getSession();
			session.setAttribute("status", "loggedIn");
			return true;
		}else if(request.getRequestURI().contains("logout")){
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("status")!=null) {
				session.invalidate();
				response.sendRedirect("/Test");
				return false;
			}
		}else{
			HttpSession session = request.getSession(false);
			if (session == null || (session!=null && (session.getAttribute("status")==null))) {
				/* to enable cors*/
			/*	response.sendRedirect("/Test/invalidSession");
				return false;*/
			}
		}
		return true;
	}

}
