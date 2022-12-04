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
import com.java.bo.GroupBO;
import com.java.bo.TaskBO;
import com.java.dao.AccountDAO;
import com.java.dao.GroupDAO;
import com.java.model.Account;
import com.java.model.Group;

@WebServlet("/groupTask")
public class GroupController extends HttpServlet{
	private ArrayList<Group> listGroupTask = new ArrayList<Group>();
	private GroupBO groupBO = new GroupBO();
	private TaskBO taskBO = new TaskBO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();

		
		String groupId = req.getParameter("groupId");
		String action = req.getParameter("action");
		System.out.println("groupId id " + groupId);
		System.out.println("action " + action);
		//update account
		if(groupId != null && !groupId.equals("") && action.equals("update")) {
			Group groupTask = groupBO.getGroupTaskById(Integer.parseInt(groupId));
			System.out.println("Name group " + groupTask.getGroupName());
			String json = gson.toJson(groupTask);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.flush();
			out.close();
			listGroupTask = groupBO.getAll();
			System.out.println("go to update");
		}else if(groupId != null && !groupId.equals("") && action.equals("delete")){
			//delete 
			taskBO.deleteTaskByGroupId(Integer.parseInt(groupId));
			groupBO.deleteGroupTask(Integer.parseInt(groupId));
			listGroupTask = groupBO.getAll();
			System.out.println("go to delete");
		}
		
		listGroupTask = groupBO.getAll();
		System.out.println("go to page");
		req.setAttribute("listGroupTask", listGroupTask);	
		req.getRequestDispatcher("group/listGroupTask.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String groupId = "";
		if(!req.getParameter("groupId").equals("")) {
			groupId = req.getParameter("groupId");
		}
		if(groupId.equals("")) {
			//insert
			Group groupTask = new Group();
			groupTask.setGroupName(req.getParameter("groupName"));
			groupTask.setDescription(req.getParameter("description"));
			
			groupBO.insertGroupTask(groupTask);
		} else {
			//update
			Group groupTask = new Group();
			groupTask.setGroupId(Integer.parseInt(req.getParameter("groupId")));
			groupTask.setGroupName(req.getParameter("groupName"));
			groupTask.setDescription(req.getParameter("description"));
			
			groupBO.updateGroupTasks(groupTask);
		}
		
		
		listGroupTask = groupBO.getAll();
		req.setAttribute("listGroupTask", listGroupTask);	
		req.getRequestDispatcher("group/listGroupTask.jsp").forward(req, resp);	
	}
}
