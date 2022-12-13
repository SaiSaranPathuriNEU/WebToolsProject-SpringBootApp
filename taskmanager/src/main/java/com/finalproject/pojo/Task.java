package com.finalproject.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;
    
    @Column(name ="userName")
    private String userName;

    @Column(name ="description")
    private String description;

    @Column(name ="targetDate")
    private Date targetDate;
    
    @Column(name ="email")
    private String email;

    public Task() {
        super();
    }

    public Task(String user, String desc, Date targetDate,String email, boolean isDone) {
        super();
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;   
        this.setUserEmail(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String user() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

	public String getUserEmail() {
		return email;
	}

	public void setUserEmail(String email) {
		this.email = email;
	}
}