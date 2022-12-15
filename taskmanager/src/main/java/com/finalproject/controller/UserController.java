package com.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

import com.finalproject.dao.taskDAO;
import com.finalproject.dao.userDAO;
import com.finalproject.pojo.Task;
import com.finalproject.pojo.User;
import com.finalproject.validator.userValidation;


@Controller
public class UserController {
	
	@Autowired
	userValidation userValidations;
	
	@Autowired
	userDAO userDao;
	
	@Autowired
	taskDAO taskDao;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	protected String handleRequest(HttpServletRequest request){
		// TODO Auto-generated method stub
		User user = (User) userDao.getUser(1L);
		
		request.setAttribute("user", user);
		return "user-view";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String toRegisterView(ModelMap model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User regUser,
								BindingResult result,userDAO userDAO, 
								HttpServletRequest request,ModelMap model) 
										throws IllegalStateException{
		
		//Validation the user details
		userValidations.validate(regUser,result);
		if(result.hasErrors()) {
			return "register";
		}
		
		try {
			User u = userDao.registerUser(regUser);
			if(u != null) {
				return "login";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginUser(userDAO userDAO, HttpServletRequest request) throws IllegalStateException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		try {
			User user = userDao.loginUser(email, password, role);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", user);
				//return "user-view";
				System.out.println("Inside login");
				System.out.println(user.getRole().toString());
				if(user.getRole().toString().equals("Admin"))
				{
					
					System.out.println("Inside admin");
					
					List<Task> adminTasks = taskDao.getAdminTasks(user);
					List<User> allUsers = userDao.getAllUsers();
					//List<Task> assignedTask = user
					request.setAttribute("tasks", adminTasks);
					request.setAttribute("role", user.getRole());
					request.setAttribute("allUsers", allUsers);
					
				return "adminDashboard";
				}
				else {
                    System.out.println("Inside user");
					
					List<Task> userTasks = taskDao.getUserTasks(user);
					
					request.setAttribute("tasks", userTasks);
					request.setAttribute("role", user.getRole());
					
					return "userDashboard";
				}
			}else {
				System.out.println("not logged");
				request.setAttribute("isError", "yes");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteUser/", method = RequestMethod.GET)
	   public String deleteUser(@RequestParam User user) {
	       
		  try { boolean userDeleted = userDao.deleteUser(user);
	       // service.deleteTodo(id);
		   if(userDeleted)
	       return "userDashboard";
	} catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	   }
	

	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws IllegalStateException{
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("currentUser");
		session.invalidate();
		
		return "login";
		
	}
}

