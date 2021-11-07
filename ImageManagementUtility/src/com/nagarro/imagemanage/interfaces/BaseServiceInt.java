package com.nagarro.imagemanage.interfaces;

import com.nagarro.imagemanage.models.User;

public interface BaseServiceInt {
	
	public boolean login(String username,String password);
	
	public User getUserDetails(String username) ;
	
	public void updatePassword(String Username,String Passwords);
}
