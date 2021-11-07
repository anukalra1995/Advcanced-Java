package com.nagarro.interfaces;

import java.util.List;

import com.nagarro.model.Employee;

public interface EmployeDaoInt {
	
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public Employee getEmployeeById(int id);
}
