package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.EmployeeDaoImpl;
import com.nagarro.interfaces.EmployeDaoInt;
import com.nagarro.interfaces.EmployeeServiceInt;
import com.nagarro.model.Employee;

public class EmployeeServiceImpl implements EmployeeServiceInt{
	
	EmployeDaoInt emps = new EmployeeDaoImpl();
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emps.getAllEmployees();
	}

	@Override
	public void addEmployee(Employee emp) {
		
		emps.addEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		emps.updateEmployee(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return emps.getEmployeeById(id);
	}
	
}