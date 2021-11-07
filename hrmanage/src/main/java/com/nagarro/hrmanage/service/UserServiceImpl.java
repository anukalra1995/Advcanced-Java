package com.nagarro.hrmanage.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanage.interfaces.UserDao;
import com.nagarro.hrmanage.interfaces.UserService;
import com.nagarro.hrmanage.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userdao;
	
	final static Logger LOG = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean isValid(User loginbeans) {
		
		try {
			User users =  userdao.isValid(loginbeans);
			if(loginbeans.getUsername().equals(users.getUsername()) && loginbeans.getPassword().equals(users.getPassword())) {
				System.out.println("successfully logged in");
				return true;
			}else {
				System.out.println("username or password incorrect");			
				return false;			
			}
		} catch (Exception e) {
			LOG.info("Username and pssword Incorrect");
			return false;
		}		
	}
	
}
