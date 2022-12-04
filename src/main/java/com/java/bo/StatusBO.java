package com.java.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.dao.StatusDAO;
import com.java.model.Status;

public class StatusBO {
	public ArrayList<Status> getAll() {
		ArrayList<Status> listStatus = new ArrayList<Status>();
		StatusDAO statusDAO = new StatusDAO();
		listStatus = statusDAO.getAll();
		return listStatus;
	}
}
