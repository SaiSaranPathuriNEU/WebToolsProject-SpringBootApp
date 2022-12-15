package com.finalproject.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.finalproject.dao.taskDAO;
import com.finalproject.pojo.Task;


@Service
public class taskValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Task.class.isAssignableFrom(clazz);
	}

	@Override
	public  void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		try {
		Task task = (Task)target;
		System.out.print("validations");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assignedTo", "errors.assignedTo","Assigned To is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "errors.description","Description is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "createdBy", "errors.createdBy","Created By is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "errors.status","status is requred");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e.getMessage());
		}
		
	}

}

