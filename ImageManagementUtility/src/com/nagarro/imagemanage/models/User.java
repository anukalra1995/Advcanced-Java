package com.nagarro.imagemanage.models;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "username")
	String username;
	
	@Column(name = "fullname")
	String fullName;
	
	@Column(name = "password")
	String password;
	
	@OneToMany(mappedBy = "user")
    private List<ImageDetails> images = new ArrayList<ImageDetails>();

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String username, String password, List<ImageDetails> images) {
		super();
		this.fullName = name;
		this.username = username;
		this.password = password;
		this.images = images;
	}

	public User(String username,String fullName,String password) {
		
		this.fullName=fullName;
		this.password=password;
		this.username=username;
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<ImageDetails> getImages() {
		return images;
	}
	public void setImages(List<ImageDetails> images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", fullName=" + fullName + ", password=" + password + "]";
	}
}
