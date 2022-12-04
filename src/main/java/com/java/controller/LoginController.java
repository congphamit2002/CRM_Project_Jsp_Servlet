package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bo.AccountBO;
import com.java.constant.Constant;
import com.java.dao.AccountDAO;
import com.java.model.Account;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	private AccountBO accountBO = new AccountBO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Account account = accountBO.checkLogin(email, password);
			if(account != null) {
				Cookie cookie = new Cookie(Constant.COOKIE_USER, account.getFullname());
				cookie.setMaxAge(10*60);
				resp.addCookie(cookie);
				resp.sendRedirect(req.getContextPath() + "/accounts");
			} else {
				System.out.println("Login failed");
				req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
			}
		} else {

			resp.sendRedirect(req.getContextPath() + "/accounts");
		}
		
	}
}
