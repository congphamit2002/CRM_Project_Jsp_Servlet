package com.java.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.dao.AccountDAO;
import com.java.model.Account;

public class AccountBO {
	public ArrayList<Account> getAll() {
		ArrayList<Account> listAccount = new ArrayList<Account>();
		AccountDAO accountDAO = new AccountDAO();
		listAccount =  accountDAO.getAll();
		return listAccount;
	}
	
	public Account getAccountById(int id) {
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		account = accountDAO.getAccountById(id);
		return account;
	}
	
	public ArrayList<Integer> getAccounIdtByGroupId(int id) {
		ArrayList<Integer> listIds = new ArrayList<Integer>();
		AccountDAO accountDAO = new AccountDAO();
		listIds = accountDAO.getAccounIdtByGroupId(id);
		return listIds;
	}
	
	public int insertAccount(Account account) {
		AccountDAO accountDAO = new AccountDAO();
		return accountDAO.insertAccount(account);
	}
	
	public int updateAccount(Account account) {
		AccountDAO accountDAO = new AccountDAO();
		return accountDAO.updateAccount(account);
	}
	
	public int deleteAccount(int accountId) {
		AccountDAO accountDAO = new AccountDAO();
		return accountDAO.deleteAccount(accountId);
	}
	
	public Account checkLogin(String email, String password) {

		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		account = accountDAO.checkLogin(email, password);
		return account;
	}
}
