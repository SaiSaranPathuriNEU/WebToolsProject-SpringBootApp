package com.finalproject.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;
import org.hibernate.query.Query;
import com.finalproject.pojo.User;

@Component
public class userDAO extends DAO {
	public User getUser(long id) {
		return (User) getSession().get("com.finalproject.pojo.User",id);
	}
	
	public User registerUser(User user) throws Exception{
		try {
			System.out.println("inside userDAO  "+ user.getEmail()+"  "+ user.getRole() + user.getPassword());
			begin();
			getSession().save(user);
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			// TODO: handle exception
                        rollback();
                        return null;
		}
//		return u;
	}
	
	public User loginUser(String email, String password, String role) throws Exception {
		try {
			begin();
			
			Query query = getSession().createQuery("from User where email = :email and password = :password and role = :role");
			query.setString("email", email);
			query.setString("password", password);
			query.setString("role", role);
			User user = (User) query.uniqueResult();
                        close();
			return user;
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		return null;
	}
	
	public User getUserEmail(String email) {
		try {
			begin();
			Query query = getSession().createQuery("from User where email = :email");
			query.setString("email", email);
				
			User user = (User) query.uniqueResult();
			commit();
			return user;
			
		} catch (HibernateException e) {
			// TODO: handle exception
                    rollback();
		}
		return null;
	}
	
   public User getAllUsers() {
	   String role = "Admin";
	   try {
		   begin();
		   Query query = getSession().createQuery("from User where role != :role");
		    
	   }
	   catch (HibernateException e) {
			// TODO: handle exception
                   rollback();
		}
		return null;
   }
}

