package com.finalproject.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;
import org.hibernate.query.Query;

import com.finalproject.pojo.Task;
import com.finalproject.pojo.User;

@Component
public class taskDAO extends DAO {
	
	public List<Task> getAdminTasks(User user) throws Exception{
		String email=user.getEmail();
		try {
			
			System.out.println("inside getAdminTasks the admin is:  "+ email);
			begin();
			Query query = getSession().createQuery("from Task where createdBy = :email");
			query.setParameter("email", email);
			List tasks = query.list();
			commit();
			return tasks;
		} catch (HibernateException e) {
			// TODO: handle exception
                        rollback();
                        return null;
		}
//		return u;
	}
	
	public List<Task> getUserTasks(User user) {
		String email=user.getEmail();
		try {
			begin();
			Query query = getSession().createQuery("from Task where assignedTo = :email");
			query.setParameter("email", email);
			List tasks = query.list();
			commit();
			return tasks;
			
		} catch (HibernateException e) {
			// TODO: handle exception
                    rollback();
		}
		return null;
	}
	
	public List<Task> getAssignedTasks(User user) {
		String email=user.getEmail();
		String assignedto ="";
		try {
			begin();
			Query query = getSession().createQuery("from Task where assignedTo != :assignedto or assignedTo != NULL and createdBy = :email ");
			query.setParameter("email", email);
			query.setParameter("assignedto", assignedto);
			List tasks = query.list();
			commit();
			return tasks;
			
		} catch (HibernateException e) {
			// TODO: handle exception
                    rollback();
		}
		return null;
	}
	
   public Task addTask(Task task) {
	   try {
			
			System.out.println("inside addTask()  "+ task.getDescription()+"  "+ task.getCreatedBy() + task.getAssignedTo());
			begin();
			getSession().save(task);
			commit();
			close();
			return task;
		} catch (HibernateException e) {
			// TODO: handle exception
                       rollback();
                       return null;
		}
   }
   
   public Task updateTask(Task task) {
	   long taskID=task.getId();
		try {
			begin();
			Query query = getSession().createQuery("from Task where id = :taskID");
			query.setParameter("id", taskID);
			Task resTask = (Task) query.uniqueResult();
			
			if(resTask != null) {
				resTask.setAssignedTo(task.getAssignedTo()); 
				resTask.setDescription(task.getDescription()); 
				resTask.setTargetDate(task.getTargetDate());    
				resTask.setCreatedBy(task.getCreatedBy()); 
				resTask.setComments(task.getComments());
				resTask.setStatus(task.getStatus()); 
				
				getSession().update(resTask);
				commit();
				close();
			}
			
		} catch (HibernateException e) {
			// TODO: handle exception
                   rollback();
		}
		return null;
   }
   
   public void removeTask(Task task) {
	   
		try {
			begin();
			
			getSession().delete(task);
			
			commit();
			close();
		} catch (HibernateException e) {
			// TODO: handle exception
                       rollback();
			e.printStackTrace();
                       
		}
	}
   
}

