package com.nagarro.hrmanage.controller;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.hrmanage.constants.UrlTypes;
import com.nagarro.hrmanage.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeeController {
	
	static RestTemplate restTemplate = new RestTemplate();
	
	@SuppressWarnings("unchecked")
	public static List<Employee> fetchEmployees() {
		
		List<Employee> users = restTemplate.getForObject(UrlTypes.getAllEmpl, List.class);
		for(int i=0; i<users.size();i++) {
			System.out.println(users.get(i));
		}
		return users;
	}
	
	public static Employee fetchEmployeeId(int id) throws JsonMappingException, JsonProcessingException {
		
		Employee employee = restTemplate.getForObject(UrlTypes.getOneEmpl+id, Employee.class);
		System.out.println(employee);
		return employee;		
	}
	
	public static void updateEmployee(Employee emp) throws JsonProcessingException {
		
		System.out.println(emp);
		ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println("json value: "+json);
		Client client = Client.create();
		WebResource webResource = client.resource(UrlTypes.updateEmpl);
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);
		System.out.println(response);
		response.close();
	}
	
}
