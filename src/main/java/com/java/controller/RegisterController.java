package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bo.AccountBO;
import com.java.dao.AccountDAO;
import com.java.model.Account;

@WebServlet("/register")
public class RegisterController extends HttpServlet{
	
	private AccountBO accountBO = new AccountBO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("auth/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Account account = new Account();
		account.setFullname(req.getParameter("fullname"));
		account.setEmail(req.getParameter("email"));
		account.setPassword(req.getParameter("password"));
		account.setAddress(req.getParameter("address"));
		account.setPhone( req.getParameter("phone"));
		
		if(accountBO.insertAccount(account) > 0) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			System.out.println("Register failed");
			req.getRequestDispatcher("auth/register.jsp").forward(req, resp);
		}
		
	}
}
