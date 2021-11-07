package com.nagarro.hrmanage.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanage.interfaces.UserDao;
import com.nagarro.hrmanage.model.User;

@Service
public class UserDaoImpl implements UserDao{
	
	@Resource(name="sessionFactory")
	SessionFactory sessionfactory;
	
	@Override
	public User isValid(User LoginBeans) {			
			Session sessions = sessionfactory.openSession();
			User users = (User)sessions.get(User.class,LoginBeans.getUsername());
			System.out.println(users);
			return users;
	}
}
