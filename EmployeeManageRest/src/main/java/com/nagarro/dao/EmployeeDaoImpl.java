package com.nagarro.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.interfaces.EmployeDaoInt;
import com.nagarro.model.Employee;
import com.nagarro.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeDaoInt{
	
	/**
	 *  Returns list of all Employees Data from Database
	 */	
	@Override
	public List<Employee> getAllEmployees() {
		
		Session sessions = HibernateUtil.getSession();
		List<Employee> emplists = null;
		if(sessions != null) {
			Query<Employee> query = sessions.createQuery("FROM Employee", Employee.class);
			emplists = query.list();
		}
		sessions.close();
		return emplists;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		
		Session sessions = HibernateUtil.getSession();
		Employee emp = new Employee();
		if(sessions!= null) {
			Query<Employee> query = sessions.createQuery("from Employee where empcode = :id",Employee.class).setParameter("id", id);
			emp = (Employee)query.uniqueResult();
		}
		sessions.close();
		return emp;
	}
	
	@Override
	public void addEmployee(Employee emp) {
		
		Session sessions = HibernateUtil.getSession();
		if(sessions!=null){
			sessions.beginTransaction();
			sessions.save(emp);
			System.out.println("added data");
			sessions.getTransaction().commit();
			sessions.close();
		}
	}
	@Override
	public void updateEmployee(Employee emp) {
		
		Session sessions = HibernateUtil.getSession();
		if(sessions!=null){
		sessions.beginTransaction();
		sessions.update(emp);
		System.out.println("updated");
		sessions.getTransaction().commit();
		sessions.close();
		}
	}
}
