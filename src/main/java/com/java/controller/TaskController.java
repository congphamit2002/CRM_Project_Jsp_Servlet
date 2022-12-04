package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.java.bo.AccountBO;
import com.java.bo.StatusBO;
import com.java.bo.TaskBO;
import com.java.dao.AccountDAO;
import com.java.dao.StatusDAO;
import com.java.dao.TaskDAO;
import com.java.model.Account;
import com.java.model.ChartTaskItem;
import com.java.model.Group;
import com.java.model.GroupTask;
import com.java.model.Status;
import com.java.model.Tasks;

@WebServlet("/taskList")
public class TaskController extends HttpServlet{
	
	private TaskBO taskBO = new TaskBO();
	private AccountBO accountBO = new AccountBO();
	private StatusBO statusBO = new StatusBO();
	ArrayList<Status> listStatus = new ArrayList<Status>();
	ArrayList<Account> listAccount = new ArrayList<Account>();
	ArrayList<Tasks> listTasks = new ArrayList<Tasks>();
	Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String taskId = req.getParameter("taskId");
		String action = req.getParameter("action");
		if(taskId != null && !taskId.equals("") && action.equals("update")) {
			Tasks tasks = taskBO.getTaskById(Integer.parseInt(taskId));
			String json = gson.toJson(tasks);
			System.out.println("JSON " + json);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.flush();
			out.close();
			System.out.println("go to update");
		}else if(taskId != null && !taskId.equals("") && action.equals("delete")){
			System.out.println("go to delete");
		}
		System.out.println("group Id " + req.getParameter("groupId"));
		ArrayList<GroupTask> listGroupTasks = new ArrayList<GroupTask>();
		ArrayList<Integer> listAccountId = new ArrayList<Integer>();
		ArrayList<ChartTaskItem> listChartItem = new ArrayList<ChartTaskItem>();
		
		listAccountId = accountBO.getAccounIdtByGroupId(Integer.parseInt(req.getParameter("groupId")));
		
		for(Integer item : listAccountId) {
			GroupTask  groupTask = new GroupTask();
			groupTask.setFullname(accountBO.getAccountById(item).getFullname());
			groupTask.setListTasks(taskBO.getTasksByAccountIdAndGrId(item, Integer.parseInt(req.getParameter("groupId"))));
			listGroupTasks.add(groupTask);
		}
		
		listChartItem = taskBO.getChartTaskItemByGroupId(Integer.parseInt(req.getParameter("groupId")));
		for(ChartTaskItem item : listChartItem) {
			System.out.println("count " + item.getCountItem() + " - status id " + item.getStatusId());
		}
		listStatus = statusBO.getAll();
		listAccount = accountBO.getAll();
		req.setAttribute("listChartItem", listChartItem);
		req.setAttribute("listGroupTasks", listGroupTasks);
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
			
			taskBO.insertTask(tasks);
		} else {
			//update
			Tasks tasks = new Tasks();
			tasks.setTaskId(Integer.parseInt(req.getParameter("taskId")));
			tasks.setTaskName(req.getParameter("taskName"));
			tasks.setEndDate(req.getParameter("endDate"));
			tasks.setGroupId(Integer.parseInt(groupId));
			tasks.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			tasks.setAccountId(Integer.parseInt(req.getParameter("accountId")));
			
			taskBO.updateTask(tasks);
		}
		
		resp.sendRedirect(	"taskList?groupId=" + groupId + "&groupName=" + groupName);
	}
}
