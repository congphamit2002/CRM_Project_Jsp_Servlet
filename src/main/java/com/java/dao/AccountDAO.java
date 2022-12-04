package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.MySQLConnection;
import com.java.model.Account;

public class AccountDAO {
	public ArrayList<Account> getAll() {
		ArrayList<Account> listAccount = new ArrayList<Account>();
		String query = "select * from accounts";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			ResultSet rs = psttm.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setFullname(rs.getString("fullname"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				listAccount.add(account);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listAccount;
	}
	
	public Account getAccountById(int id) {
		String query = "select * from accounts where account_id = ?";

		Account account = new Account();
		try(
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);) {
			psttm.setInt(1, id);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				account.setAccountId(rs.getInt("account_id"));
				account.setFullname(rs.getString("fullname"));
				account.setAddress(rs.getString("address"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setPhone(rs.getString("phone"));;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
	}
	
	public ArrayList<Integer> getAccounIdtByGroupId(int id) {
		String query = "select distinct account_id from tasks where group_id = ?;";
		ArrayList<Integer> listIds = new ArrayList<Integer>();
		try(
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);) {
			psttm.setInt(1, id);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				listIds.add(rs.getInt("account_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listIds;
	}
	
	public int insertAccount(Account account) {
		String query = "insert into accounts(fullname, email, password, address, phone) values(?,?,?,?,?);";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setString(1, account.getFullname());
			psttm.setString(2, account.getEmail());
			psttm.setString(3, account.getPassword());
			psttm.setString(4, account.getAddress());
			psttm.setString(5, account.getPhone());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateAccount(Account account) {
		String query = "update accounts set fullname = ?, email = ?, password = ?, address = ?, phone = ? where account_id = ?;";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setString(1, account.getFullname());
			psttm.setString(2, account.getEmail());
			psttm.setString(3, account.getPassword());
			psttm.setString(4, account.getAddress());
			psttm.setString(5, account.getPhone());
			psttm.setInt(6, account.getAccountId());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteAccount(int accountId) {
		String query = "delete from accounts where account_id = ?";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, accountId);
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Account checkLogin(String email, String password) {
		String query = "select * from accounts where email = ? and password = ?;";

		Account account = new Account();
		try(
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);) {
			psttm.setString(1, email);
			psttm.setString(2, password);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				account.setAccountId(rs.getInt("account_id"));
				account.setFullname(rs.getString("fullname"));
				account.setAddress(rs.getString("address"));
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setPhone(rs.getString("phone"));;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
	}
} 
