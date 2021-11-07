package com.nagarro.imagemanage.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.imagemanage.hibernateutil.HibernatUtil;
import com.nagarro.imagemanage.interfaces.BaseDaoInt;
import com.nagarro.imagemanage.interfaces.BaseServiceInt;
import com.nagarro.imagemanage.models.User;

public class BaseService implements BaseServiceInt{
	User user = null;
	private BaseDaoInt logins = new BaseDao();
	
	@Override
	public boolean login(String username, String password) {
		
		return logins.login(username, password);
	}

	@Override
	public User getUserDetails(String username) {
		
		Transaction tx = null;
		try (Session session = HibernatUtil.getSession();) {
			
			tx = session.getTransaction();
			tx.begin();
//	        Query query = session.createQuery("from User where userName ='"+username+"'");
//	        
//	        user = (User)query.uniqueResult();
			
			user = session.get(User.class, username);
			
			tx.commit();
	        
		} catch (Exception e) {
	        	if (tx != null) {
	                tx.rollback();
	            }
	            System.out.println(e.getMessage());
	        }
	        return user;
	}

	
	@Override
	public void updatePassword(String Username, String Passwords) {
		
		try(Session session = HibernatUtil.getSession();) {
			session.getTransaction().begin();
			
			user = (User) session.get(User.class,Username);
			user.setPassword(Passwords);
			session.update(user);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
}
