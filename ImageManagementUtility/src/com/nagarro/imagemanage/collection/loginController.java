package com.nagarro.imagemanage.collection;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imagemanage.interfaces.BaseServiceInt;
import com.nagarro.imagemanage.models.ImageDetails;
import com.nagarro.imagemanage.models.User;
import com.nagarro.imagemanage.services.BaseService;
import com.nagarro.imagemanage.services.ImageManagingService;

/**
 * @author anukalra
 *
 *This Servlet is for Login Authentication
 */

@WebServlet("/Home")
public class loginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String page = "Login.jsp";
		
		if(username.trim().length() >= 0 && username != null && password.trim().length() >= 0 && password != null) {
			
			BaseServiceInt loginservice = new BaseService();
			boolean flag = loginservice.login(username, password);
			
			if(flag) {
				
				//Getting user Details
				User users = loginservice.getUserDetails(username);
				
				//Mapping user details with images inserted into db
				ImageManagingService imageserve = new ImageManagingService();
				List<ImageDetails> allImageOfUser = imageserve.getAllImageOfUser(users.getUsername());
				request.getSession().setAttribute("imageList", allImageOfUser);
				
				users.setImages(allImageOfUser);
//				System.out.println(users.getImages());
				//Setting ATTRIBUTES
				request.getSession().setAttribute("username",username);
				request.getSession().setAttribute("user", users);
				

				request.setAttribute("authorized", "true");
				request.setAttribute("msg", "Login successful");
				
				page = "Home.jsp";
				
			}else {
				
				request.getSession().setAttribute("authorized", "false");
				request.setAttribute("msg", "UserName or Password Incorrect");
				page="Login.jsp";
			}
			
		}else {

			request.getSession().setAttribute("authorized", "false");
			
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
