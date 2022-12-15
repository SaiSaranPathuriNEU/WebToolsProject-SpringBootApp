package com.finalproject.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.query.Query;
import com.finalproject.pojo.User;

@Component
public class userDAO extends DAO {
	
	public User getUser(long id) {
		return (User)getSession().get("com.finalproject.pojo.User",id);
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

	}
	
	public User loginUser(String email, String password, String role) throws Exception {
		try {
			begin();
			
			Query query = getSession().createQuery("from User where email = :email and password = :password and role = :role");
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("role", role);
			User user = (User) query.uniqueResult();
                        close();
			return user;
		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public User getUserbyEmail(String email) {
		try {
			begin();
			Query query = getSession().createQuery("from User where email = :email");
			query.setParameter("email", email);
				
			User user = (User) query.uniqueResult();
			commit();
			return user;
			
		} catch (HibernateException e) {
			// TODO: handle exception
                    rollback();
		}
		return null;
	}
	
   public List<User> getAllUsers() {
	   String role = "Admin";
	   
	   try {
		   begin();
		   Query query = getSession().createQuery("from User where role != :role");
		   query.setParameter("role", role);
		   
		  List users = query.list();
		  return users;
	   }
	   catch (HibernateException e) {
			// TODO: handle exception
                   rollback();
		}
		return null;
   }
   
  
  public boolean deleteUser(User user) {
 	 try {
          //save user object in the database
      	begin();

      	getSession().delete(user);
      	commit();
      	 return true;
      	
      } catch (HibernateException e) {
          rollback();
         return false;
      }
 }
	 
   
   public List<String> getAllUsersEmails() {
	   String role = "Admin";
	   
	   try {
		   begin();
		   Query query = getSession().createQuery("email from User where role != :role");
		   query.setParameter("role", role);
		   List userEmails = query.list();
		   
		  return userEmails;
	   }
	   catch (HibernateException e) {
			// TODO: handle exception
                   rollback();
		}
		return null;
   }
}

