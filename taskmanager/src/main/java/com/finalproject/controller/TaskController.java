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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("task") Task createdTask,
								BindingResult result,taskDAO taskDao, 
								HttpServletRequest request,ModelMap model) 
										throws IllegalStateException{
    	try {
		//Validation the user details
    	
		if(createdTask.getAssignedTo() != null) {
			
			Task task = taskDao.addTask(createdTask);
			if(task != null) {
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
	
	
	
}
