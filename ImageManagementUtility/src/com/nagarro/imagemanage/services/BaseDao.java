package com.nagarro.imagemanage.services;

import org.hibernate.Session;

import com.nagarro.imagemanage.hibernateutil.HibernatUtil;
import com.nagarro.imagemanage.interfaces.BaseDaoInt;
import com.nagarro.imagemanage.models.User;

public class BaseDao implements BaseDaoInt{

	@Override
	public boolean login(String username, String password) {
		Session sessions = HibernatUtil.getSession();
		
		if(sessions!=null) {
			try {
				sessions.getTransaction().begin();
				User users = (User) sessions.get(User.class, username);
				if(username.equals(users.getUsername()) && password.equals(users.getPassword())) {
					return true;
				}else {
					return false;
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}else {
			System.out.println("DB server down");
		}
		
		return false;
	}
}
