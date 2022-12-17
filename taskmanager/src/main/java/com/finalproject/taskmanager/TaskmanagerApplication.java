package com.finalproject.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.finalproject.controller","com.finalproject.pojo","com.finalproject.dao","com.finalproject.validator"})
public class TaskmanagerApplication extends SpringBootServletInitializer implements WebMvcConfigurer{

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}
