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
    
    @Column(name ="assignedTo")
    private String assignedTo;

    @Column(name ="description")
    private String description;

    @Column(name ="targetDate")
    private Date targetDate;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "status")
    private String status;

    public Task() {
        super();
    }

    public Task(String admin, String assignedTo, String desc, Date targetDate,String comments, String status) {
        super();
        this.assignedTo = assignedTo;
        this.description = desc;
        this.targetDate = targetDate;   
        this.createdBy = admin;
        this.comments = comments;
        this.status = status;
        
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}