package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.AccountDAO;
import com.java.dao.StatusDAO;
import com.java.dao.TaskDAO;
import com.java.model.Account;
import com.java.model.GroupTask;
import com.java.model.Status;
import com.java.model.Tasks;

@WebServlet("/taskList")
public class TaskController extends HttpServlet{
	
	TaskDAO taskDAO = new TaskDAO();
	AccountDAO accountDAO = new AccountDAO();
	StatusDAO statusDAO = new StatusDAO();
	ArrayList<Status> listStatus = new ArrayList<Status>();
	ArrayList<Account> listAccount = new ArrayList<Account>();
	ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		listStatus = statusDAO.getAll();
		listAccount = accountDAO.getAll();
		req.setAttribute("listStatus", listStatus);
		req.setAttribute("listAccount", listAccount);
		req.getRequestDispatcher("/tasks/taskList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String groupId = req.getParameter("groupId");
		String taskId = req.getParameter("taskId");
		String groupName = req.getParameter("groupName");
		
		if(taskId.equals("")) {
			//insert
			Tasks tasks = new Tasks();
			tasks.setTaskName(req.getParameter("taskName"));
			tasks.setEndDate(req.getParameter("endDate"));
			tasks.setGroupId(Integer.parseInt(groupId));
			tasks.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			tasks.setAccountId(Integer.parseInt(req.getParameter("accountId")));
			
			taskDAO.insertTask(tasks);
		} else {
			//update
//			GroupTask groupTask = new GroupTask();
//			groupTask.setGroupId(Integer.parseInt(req.getParameter("groupId")));
//			groupTask.setGroupName(req.getParameter("groupName"));
//			groupTask.setDescription(req.getParameter("description"));
//			
//			groupDAO.updateGroupTasks(groupTask);
		}
		
		resp.sendRedirect(	"taskList?groupId=" + groupId + "&groupName=" + groupName);
	}
}
