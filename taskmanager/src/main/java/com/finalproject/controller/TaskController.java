package com.finalproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.dao.taskDAO;
import com.finalproject.dao.userDAO;
import com.finalproject.pojo.Task;
import com.finalproject.pojo.User;
import com.finalproject.validator.taskValidation;

@Controller
public class TaskController {
	
	
	@Autowired
	userDAO userDao;
	
	@Autowired
	taskDAO taskDao;
	
	@Autowired
	taskValidation taskValidate;
	
 
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
		//Setting dataformat for the taskCreation
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
    public String showCreateTaskPage(ModelMap model,HttpServletRequest request) {
		List<String> allUsersEmails = new ArrayList<String>();
		allUsersEmails.add("None");
		List<User> allUsers = userDao.getAllUsers();
		
		for(User user : allUsers) {
			allUsersEmails.add(user.getEmail());
		}
		//List<Task> assignedTask = user
		request.setAttribute("allUsersEmails", allUsersEmails);
		request.setAttribute("callingScreen", "Create");
        model.addAttribute("task", new Task());
        return "task";
    }
	
	@RequestMapping(value = "/editTask/{id}", method = RequestMethod.GET)
    public String showTaskPageForEdit(@PathVariable("id") long id,ModelMap model,HttpServletRequest request) {
		List<String> allUsersEmails = new ArrayList<String>();
		allUsersEmails.add("None");
		List<User> allUsers = userDao.getAllUsers();
		
		for(User user : allUsers) {
			allUsersEmails.add(user.getEmail());
		}
		//List<Task> assignedTask = user
		
		Task task = taskDao.getTaskbyId(id);
		request.setAttribute("allUsersEmails", allUsersEmails);
		request.setAttribute("callingScreen", "Create");
		request.setAttribute("task", task);
        return "editTask";
    }
	
	
	@RequestMapping(value = "editTask/posteditedTask/{id}", method = RequestMethod.POST)
    public String editTask(@PathVariable("id") long id,HttpServletRequest request) 
	{
		System.out.println("Inside delete task");
		try {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		String assignedTo = request.getParameter("assignedTo");
        String description = request.getParameter("description");
        String targetDate = request.getParameter("targetDate");   
       String createdBy = request.getParameter("createdBy");
        String comments = request.getParameter("comments");
        String status = request.getParameter("status");
		Task editedTask = new Task(id,createdBy,assignedTo,description,targetDate,comments,status);
		taskDao.updateTask(editedTask);
		
		List<String> allUsersEmails = new ArrayList<String>();
		allUsersEmails.add("None");
		List<User> allUsers = userDao.getAllUsers();
		
		for(User arguser : allUsers) {
			allUsersEmails.add(arguser.getEmail());
		}
		//List<Task> assignedTask = user
		List<Task> adminTasks = taskDao.getAdminTasks(user); 
		//List<Task> assignedTask = user
		request.setAttribute("tasks", adminTasks);
		request.setAttribute("role", user.getRole());
		request.setAttribute("allUsers", allUsers);
		request.setAttribute("allUsersEmails", allUsersEmails);
		request.setAttribute("callingScreen", "Create");
		request.setAttribute("task", new Task());
        return "adminDashboard";
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "adminDashboard";
    }
	
	@RequestMapping(value = "/changeTaskStatus/{id}", method = RequestMethod.GET)
    public String changeTaskStatus(@PathVariable("id") long id,HttpServletRequest request) 
	{
		System.out.println("Inside delete task");
		try {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		
        
        
        Task task=taskDao.getTaskbyId(id);
        
        if(task.getStatus().equals("New Task")) {
          String arg_status = "Working";
		Task editedTask = new Task(id,task.getCreatedBy(),task.getAssignedTo(),task.getDescription(),task.getTargetDate(),task.getComments(),arg_status);
		taskDao.updateTask(editedTask);
        }
        else if(task.getStatus().equals("Working")) {
        	String arg_status = "Completed";
        	Task editedTask = new Task(id,task.getCreatedBy(),task.getAssignedTo(),task.getDescription(),task.getTargetDate(),task.getComments(),arg_status);
    		taskDao.updateTask(editedTask);
        }
		
		//List<Task> assignedTask = user 
		//List<Task> assignedTask = user
		List<Task> userTasks = taskDao.getUserTasks(user);
		
		request.setAttribute("tasks", userTasks);
		request.setAttribute("role", user.getRole());
        return "userDashboard";
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "userDashboard";
    }

	@RequestMapping(value = "/dropUserTask/{id}", method = RequestMethod.GET)
    public String dropUserTask(@PathVariable("id") long id,HttpServletRequest request) 
	{
		System.out.println("Inside delete task");
		try {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		Task task=taskDao.getTaskbyId(id);
        
		Task editedTask = new Task(id,task.getCreatedBy(),"None",task.getDescription(),task.getTargetDate(),task.getComments(),"New Task");
		taskDao.updateTask(editedTask);

       List<Task> userTasks = taskDao.getUserTasks(user);
		
		request.setAttribute("tasks", userTasks);
		request.setAttribute("role", user.getRole());
        return "userDashboard";
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "userDashboard";
    }

	
    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public String createTask(@ModelAttribute("task") Task createdTask,
								BindingResult result,taskDAO taskDao, 
								HttpServletRequest request,ModelMap model) 
										throws IllegalStateException{
    	try {
		//Validation the user details
    	
		if(createdTask.getAssignedTo() != null) {
			
			Task task = taskDao.addTask(createdTask);
			if(task != null) {
				HttpSession session = request.getSession();
 				User user = (User) session.getAttribute("currentUser");
 				//return "user-view";
 				System.out.println("Inside delete task");

 					List<Task> adminTasks = taskDao.getAdminTasks(user);
 					List<User> allUsers = userDao.getAllUsers();
 					//List<Task> assignedTask = user
 					request.setAttribute("tasks", adminTasks);
 					request.setAttribute("role", user.getRole());
 					request.setAttribute("allUsers", allUsers);
				//return "adminDashboard";
 				return "adminDashboard";
			}
		}
		else {
			System.out.println("task not created!");
			request.setAttribute("isError", "yes");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	
    }
    
    
	
    @RequestMapping(value="/deleteTask/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") long id,HttpServletRequest request) {
    	 try {
    	
 				HttpSession session = request.getSession();
 				User user = (User) session.getAttribute("currentUser");
 				//return "user-view";
 				System.out.println("Inside delete task");
	
 				taskDao.deleteTask(id);
 					if(user.getRole().equals("Admin")) {
 					List<Task> adminTasks = taskDao.getAdminTasks(user);
 					List<User> allUsers = userDao.getAllUsers();
 					//List<Task> assignedTask = user
 					request.setAttribute("tasks", adminTasks);
 					request.setAttribute("role", user.getRole());
 					request.setAttribute("allUsers", allUsers);
 					
 				return "adminDashboard";
 				}else {
 					 List<Task> userTasks = taskDao.getUserTasks(user);
 					
 					request.setAttribute("tasks", userTasks);
 					request.setAttribute("role", user.getRole());
 			        return "userDashboard";
 				}
    		 
	} catch (Exception e) {
		// TODO: handle exception
	}
    	 return null;
	}
    
    
}
