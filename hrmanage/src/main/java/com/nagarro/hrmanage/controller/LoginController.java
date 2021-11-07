package com.nagarro.hrmanage.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nagarro.hrmanage.interfaces.UserService;
import com.nagarro.hrmanage.model.Employee;
import com.nagarro.hrmanage.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userserve;
	
	final static Logger LOG = Logger.getLogger(LoginController.class);
	
	private ModelAndView model = null;
	
	@RequestMapping("/")
	public void getLogin(HttpServletResponse response)  {
		
		try {
			response.sendRedirect("Login");
		} catch (IOException e) {
			LOG.error("Unable to redirect to Login Page");
		}
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public ModelAndView displayLogin() {
		
		System.out.println("displayed login page \nNow checking credentials");
		model = new ModelAndView("Login");
		User use = new User();
		model.addObject("loginusers", use);
		return model;
	}
	
	@RequestMapping(value="/Home", method=RequestMethod.POST)
	public ModelAndView ValidLogin(HttpServletRequest request,@ModelAttribute("loginusers") User users) {
		
		LOG.info("Received Sign in request by: "+users);
		try {			
			boolean isvalids =userserve.isValid(users);
			if(isvalids) {
				LOG.info("Logged In Successfully");
				model = new ModelAndView("Home");
				request.getSession().setAttribute("username", users.getUsername());
				model.addObject("employees", EmployeeController.fetchEmployees());
			}else {
				LOG.info("Invalid Username and password");
				model = new ModelAndView("Login");
				model.addObject("loginusers",users);
				System.out.println("Log in page ");
			}			
		} catch (Exception e) {
			LOG.error("Error Occurred");
		}
		return model;
	}
	
	@RequestMapping(value="/Home", method=RequestMethod.GET)
	public ModelAndView displayHome() {

		model = new ModelAndView("Home");
		model.addObject("employees", EmployeeController.fetchEmployees());
		System.out.println("Back to Home");	
		return model;
	}
	
	@RequestMapping(value="/edit", method= {RequestMethod.GET})
	public ModelAndView editDetailForm(HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
		
		model = new ModelAndView("Edit");
		String empcode = request.getParameter("id");
		System.out.println("Employee Code: "+empcode);
		model.addObject("employee",EmployeeController.fetchEmployeeId(Integer.parseInt(empcode)));
		return model;		
	}
		
	@RequestMapping(value="/editform", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView updateForm(HttpServletRequest request,@RequestParam String empcode,
											@RequestParam String empname,
											@RequestParam String emploc,
											@RequestParam String empmail,
											@RequestParam String empdob) throws JsonProcessingException {
		
		int id = Integer.parseInt(empcode);
		Employee emp = new Employee(id,empname,emploc,empmail,empdob);
		EmployeeController.updateEmployee(emp);
		System.out.println("updated");
		model=new ModelAndView("Home");
		model.addObject("employees", EmployeeController.fetchEmployees());
		return model;
	}
}
