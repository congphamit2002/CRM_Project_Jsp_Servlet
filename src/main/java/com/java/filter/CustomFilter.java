package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.constant.Constant;

@WebFilter(urlPatterns = {"/accounts", "/groupTask", "/taskList"})
public class CustomFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		Cookie[] cookies = req.getCookies();
		
		boolean existUser = false;
		if(cookies != null ) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(Constant.COOKIE_USER)) {
					existUser = true;
					break;
				}
			}
		}
		
		if(!existUser) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}else {
			chain.doFilter(req, resp);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
