package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.model.GroupTask;

public class GroupDAO {
	public ArrayList<GroupTask> getAll() {
		ArrayList<GroupTask> listGroupTask = new ArrayList<GroupTask>();
		String query = "select * from groups_task";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			ResultSet rs = psttm.executeQuery();
			
			while(rs.next()) {
				GroupTask groupTask = new GroupTask();
				groupTask.setGroupId(rs.getInt("group_id"));
				groupTask.setGroupName(rs.getString("group_name"));
				groupTask.setDescription(rs.getString("description"));
				listGroupTask.add(groupTask);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listGroupTask;
	}
	
	public GroupTask getGroupTaskById(int id) {
		String query = "select * from groups_task where group_id = ?";

		GroupTask groupTask = new GroupTask();
		try(
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);) {
			psttm.setInt(1, id);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				groupTask.setGroupId(rs.getInt("group_id"));
				groupTask.setGroupName(rs.getString("group_name"));
				groupTask.setDescription(rs.getString("description"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return groupTask;
	}
	
	public int insertGroupTask(GroupTask groupTask) {
		String query = "insert into groups_task(group_id, group_name, description) values(?,?,?);";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, groupTask.getGroupId());
			psttm.setString(2, groupTask.getGroupName());
			psttm.setString(3, groupTask.getDescription());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateGroupTasks(GroupTask groupTask) {
		String query = "update groups_task set group_name = ?, description = ? where group_id = ?;";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setString(1, groupTask.getGroupName());
			psttm.setString(2, groupTask.getDescription());
			psttm.setInt(3, groupTask.getGroupId());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteGroupTask(int groupId) {
		String query = "delete from groups_task where group_id = ?";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, groupId);
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
}
