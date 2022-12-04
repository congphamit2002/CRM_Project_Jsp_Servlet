package com.java.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.connection.MySQLConnection;
import com.java.dao.GroupDAO;
import com.java.model.Group;

public class GroupBO {
	public ArrayList<Group> getAll() {
		ArrayList<Group> listGroupTask = new ArrayList<Group>();
		GroupDAO groupDAO = new GroupDAO();
		listGroupTask = groupDAO.getAll();
		return listGroupTask;
	}
	
	public Group getGroupTaskById(int id) {
		Group groupTask = new Group();
		GroupDAO groupDAO = new GroupDAO();
		groupTask = groupDAO.getGroupTaskById(id);
		return groupTask;
	}
	
	public int insertGroupTask(Group groupTask) {
		GroupDAO groupDAO = new GroupDAO();
		return groupDAO.insertGroupTask(groupTask);
	}
	
	public int updateGroupTasks(Group groupTask) {
		GroupDAO groupDAO = new GroupDAO();
		return groupDAO.updateGroupTasks(groupTask);
		}
	
	public int deleteGroupTask(int groupId) {
		GroupDAO groupDAO = new GroupDAO();
		return groupDAO.deleteGroupTask(groupId);
	}
}
