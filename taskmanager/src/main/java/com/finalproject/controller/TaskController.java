package com.finalproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalproject.dao.taskDAO;
import com.finalproject.dao.userDAO;
import com.finalproject.pojo.Task;
import com.finalproject.pojo.User;

public class TaskController {
	
	
	@Autowired
	userDAO userDao;
	
	@Autowired
	taskDAO taskDao;
	
 
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
        model.addAttribute("task", new Task());
        return "task";
    }
	
	//public String
	
}
