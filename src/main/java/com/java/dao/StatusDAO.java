package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.model.Status;

public class StatusDAO {
	public ArrayList<Status> getAll() {
		ArrayList<Status> listStatus = new ArrayList<Status>();
		String query = "select * from status";
		try (
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				Status status = new Status();
				status.setStatusId(rs.getInt("status_id"));
				status.setStatusName(rs.getString("status_name"));
				listStatus.add(status);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listStatus;
	}
}
