package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class GroupTask {
	private String fullname;
	private ArrayList<Tasks> listTasks;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public ArrayList<Tasks> getListTasks() {
		return listTasks;
	}
	public void setListTasks(ArrayList<Tasks> listTasks) {
		this.listTasks = listTasks;
	}
	
	
}
