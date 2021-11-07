package com.nagarro.repository;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.interfaces.EmployeeServiceInt;
import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeServiceImpl;

@Path("/employees")
public class MyResource {

	private EmployeeServiceInt empdao = new EmployeeServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = empdao.getAllEmployees();
		return employees;
	}
	
	@POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public void addEmployee(Employee emp) {
		empdao.addEmployee(emp);
	}
	
	@PUT
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmployee(Employee emp) {
		System.out.println("In rest api, data of employee is: "+emp);
		empdao.updateEmployee(emp);
	}
	
	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int employeeCode) {
		
		Employee emp = empdao.getEmployeeById(employeeCode);
		return emp;
		
	}
}