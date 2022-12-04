package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.bo.AccountBO;
import com.java.bo.TaskBO;
import com.java.dao.AccountDAO;
import com.java.model.Account;

@WebServlet("/accounts")
public class AccountController extends HttpServlet{
	private ArrayList<Account> listAccounts = new ArrayList<Account>();
	private AccountBO accountBO = new AccountBO();
	private TaskBO taskBO = new TaskBO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();

		
		String accountId = req.getParameter("accountId");
		String action = req.getParameter("action");
		System.out.println("account id " + accountId);
		System.out.println("action " + action);
		//update account
		if(accountId != null && !accountId.equals("") && action.equals("update")) {
			Account account = accountBO.getAccountById(Integer.parseInt(accountId));
			System.out.println("fullname " + account.getFullname());
			String json = gson.toJson(account);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.flush();
			out.close();
		}else if(accountId != null && !accountId.equals("") && action.equals("delete")){
			//delete 
			taskBO.deleteTaskByAccountId(Integer.parseInt(accountId));
			accountBO.deleteAccount(Integer.parseInt(accountId));
			System.out.println("Delete success");
		}
		
		listAccounts = accountBO.getAll();
		System.out.println("fullname account " + listAccounts.get(0).getFullname());
		System.out.println("Chào nè");
		req.setAttribute("listAccounts", listAccounts);	
		req.getRequestDispatcher("account/listAccounts.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String accountId = "";
		if(!req.getParameter("accountId").equals("")) {
			accountId = req.getParameter("accountId");
		}
		if(accountId.equals("")) {
			Account account = new Account();
			account.setEmail((String)req.getParameter("email"));
			account.setPassword((String)req.getParameter("password"));
			account.setFullname((String)req.getParameter("fullname"));
			account.setAddress((String)req.getParameter("address"));
			account.setPhone((String)req.getParameter("phone"));
			
			accountBO.insertAccount(account);
		} else {
			Account account = new Account();
			account.setAccountId(Integer.parseInt(accountId));
			account.setEmail((String)req.getParameter("email"));
			account.setPassword((String)req.getParameter("password"));
			account.setFullname((String)req.getParameter("fullname"));
			account.setAddress((String)req.getParameter("address"));
			account.setPhone((String)req.getParameter("phone"));
			
			accountBO.updateAccount(account);
		}
		
		
		listAccounts = accountBO.getAll();
		req.setAttribute("listAccounts", listAccounts);	
		req.getRequestDispatcher("account/listAccounts.jsp").forward(req, resp);	
	}
}
