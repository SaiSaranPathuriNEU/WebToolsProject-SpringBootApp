package com.finalproject.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.finalproject.dao.userDAO;
import com.finalproject.pojo.User;

@Service
public class userValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		System.out.print("validations");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "errors.firstname","First Name is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "errors.lastname","Last Name is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.email","Email is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.password","Password is requred");
		
		String userEmail = user.getEmail();
		userDAO userdao = new userDAO();
		
		try {
			System.out.println("The Uname inside try is  : " +user.getEmail());
			User u = userdao.getUserEmail(userEmail);
			if (u != null){
				errors.rejectValue("userEmail", "errors.email", "email address already exists");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e.getMessage());
			
			
		}
		
	}

}

