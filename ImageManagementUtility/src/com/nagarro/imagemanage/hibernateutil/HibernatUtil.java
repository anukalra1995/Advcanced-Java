package com.nagarro.imagemanage.hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatUtil {
	
public static SessionFactory sessions;
	
	public static Session getSession() {
		
        sessions = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = sessions.openSession();
        
        return session;
    }
}
