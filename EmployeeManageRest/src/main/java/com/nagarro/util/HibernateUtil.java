package com.nagarro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory sessions;
	
	public static Session getSession() {
		
        sessions = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        
        Session session = sessions.openSession();
        
        return session;
    }
}
