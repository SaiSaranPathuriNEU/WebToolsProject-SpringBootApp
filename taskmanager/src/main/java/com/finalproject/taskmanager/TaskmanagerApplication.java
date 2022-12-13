package com.finalproject.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = {"com.finalproject.controller","com.finalproject.pojo","com.finalproject.dao","com.finalproject.validator"})
@SpringBootApplication
@ComponentScan({"com.finalproject.controller","com.finalproject.pojo","com.finalproject.dao","com.finalproject.validator"})
public class TaskmanagerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}
