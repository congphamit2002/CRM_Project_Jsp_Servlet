package com.java.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.dao.TaskDAO;
import com.java.model.ChartTaskItem;
import com.java.model.Tasks;

public class TaskBO {
	public ArrayList<Tasks> getAll() {
		ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
		TaskDAO taskDao = new TaskDAO();
		listTasks = taskDao.getAll();
		return listTasks;
	}
	
	public Tasks getTaskById(int id) {
		Tasks task = new Tasks();
		TaskDAO taskDao = new TaskDAO();
		task = taskDao.getTaskById(id);
		return task;
	}
	
	public int insertTask(Tasks task) {
		TaskDAO taskDao = new TaskDAO();
		return taskDao.insertTask(task);
	}
	
	public int updateTask(Tasks task) {

		TaskDAO taskDao = new TaskDAO();
		return taskDao.updateTask(task);
	}
	
	public int deleteTask(int taskId) {

		TaskDAO taskDao = new TaskDAO();
		return taskDao.deleteTask(taskId);
	}
	
	public int deleteTaskByAccountId(int accountId) {
		TaskDAO taskDao = new TaskDAO();
		return taskDao.deleteTaskByAccountId(accountId);
	}
	
	public int deleteTaskByGroupId(int groupId) {
		TaskDAO taskDao = new TaskDAO();
		return taskDao.deleteTaskByGroupId(groupId);
	}

	public ArrayList<Tasks> getTasksByAccountIdAndGrId(int accountId, int groupId) {
		ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
		

		TaskDAO taskDao = new TaskDAO();
		listTasks = taskDao.getTasksByAccountIdAndGrId(accountId, groupId);
		
		return listTasks;
	}
	
	public ArrayList<ChartTaskItem> getChartTaskItemByGroupId(int groupId) {
		ArrayList<ChartTaskItem> listChart = new ArrayList<ChartTaskItem>();

		TaskDAO taskDao = new TaskDAO();
		listChart = taskDao.getChartTaskItemByGroupId(groupId);
		return listChart;
	}
}
