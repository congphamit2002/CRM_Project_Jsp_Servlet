package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.model.ChartTaskItem;
import com.java.model.Group;
import com.java.model.Tasks;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class TaskDAO {
	public ArrayList<Tasks> getAll() {
		ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
		String query = "select * from tasks";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			ResultSet rs = psttm.executeQuery();
			
			while(rs.next()) {
				Tasks task = new Tasks();
				task.setTaskId(rs.getInt("task_id"));
				task.setTaskName(rs.getString("task_name"));
				task.setEndDate(rs.getString("end_date"));
				task.setGroupId(rs.getInt("group_id"));
				task.setAccountId(rs.getInt("account_id"));
				task.setStatusId(rs.getInt("status_id"));
				listTasks.add(task);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listTasks;
	}
	
	public Tasks getTaskById(int id) {
		String query = "select * from tasks where task_id = ?";

		Tasks task = new Tasks();
		try(
				Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);) {
			psttm.setInt(1, id);
			ResultSet rs = psttm.executeQuery();
			while(rs.next()) {
				task.setTaskId(rs.getInt("task_id"));
				task.setTaskName(rs.getString("task_name"));
				task.setEndDate(rs.getString("end_date"));
				task.setGroupId(rs.getInt("group_id"));
				task.setAccountId(rs.getInt("account_id"));
				task.setStatusId(rs.getInt("status_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return task;
	}
	
	public int insertTask(Tasks task) {
		String query = "insert into tasks(task_id, task_name, end_date, group_id, account_id, status_id) values(?,?,?,?,?,?);";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, task.getTaskId());
			psttm.setString(2, task.getTaskName());
			psttm.setString(3, task.getEndDate());
			psttm.setInt(4, task.getGroupId());
			psttm.setInt(5, task.getAccountId());
			psttm.setInt(6, task.getStatusId());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateTask(Tasks task) {
		String query = "update tasks set task_name = ?, end_date = ?, group_id = ?, account_id = ?, status_id = ? where task_id = ?;";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(6, task.getTaskId());
			psttm.setString(1, task.getTaskName());
			psttm.setString(2, task.getEndDate());
			psttm.setInt(3, task.getGroupId());
			psttm.setInt(4, task.getAccountId());
			psttm.setInt(5, task.getStatusId());
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteTask(int taskId) {
		String query = "delete from tasks where task_id = ?";
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, taskId);
			return psttm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteTaskByAccountId(int accountId) {
		String query = "delete from tasks where account_id = ?";
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
	
	public int deleteTaskByGroupId(int groupId) {
		String query = "delete from tasks where group_id = ?";
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

	public ArrayList<Tasks> getTasksByAccountIdAndGrId(int accountId, int groupId) {
		String query = "select t.task_id, t.task_name, t.end_date, t.group_id, t.account_id, t.status_id, acc.fullname"
				+ " from tasks as t"
				+ " join accounts as acc on t.account_id = acc.account_id"
				+ " where t.account_id = ? and t.group_id = ?;";
		ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
		
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, accountId);
			psttm.setInt(2, groupId);
			ResultSet rs = psttm.executeQuery();
			
			while(rs.next()) {
				Tasks task = new Tasks();
				task.setTaskId(rs.getInt("task_id"));
				task.setTaskName(rs.getString("task_name"));
				task.setEndDate(rs.getString("end_date"));
				task.setGroupId(rs.getInt("group_id"));
				task.setAccountId(rs.getInt("account_id"));
				task.setStatusId(rs.getInt("status_id"));
				task.setFullname(rs.getString("fullname"));
				listTasks.add(task);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listTasks;
	}
	
	public ArrayList<ChartTaskItem> getChartTaskItemByGroupId(int groupId) {
		String query = "SELECT COUNT(status_id) AS count_item , status_id "
				+ "FROM tasks where group_id = ? "
				+ "group by status_id;";
		ArrayList<ChartTaskItem> listChart = new ArrayList<ChartTaskItem>();
		
		try (Connection con = MySQLConnection.getConnection();
				PreparedStatement psttm = con.prepareStatement(query);){
			psttm.setInt(1, groupId);
			ResultSet rs = psttm.executeQuery();
			
			while(rs.next()) {
				ChartTaskItem chart = new ChartTaskItem();
				chart.setCountItem(rs.getInt("count_item"));
				chart.setStatusId(rs.getInt("status_id"));
				listChart.add(chart);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listChart;
	}
}