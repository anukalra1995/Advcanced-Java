package com.nagarro.imagemanage.collection;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imagemanage.interfaces.BaseServiceInt;
import com.nagarro.imagemanage.models.User;
import com.nagarro.imagemanage.services.BaseService;

@WebServlet("/PasswordController")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		String page = "Login.jsp";
		
		String users = request.getParameter("UserName");
		String npwd = request.getParameter("New_Pass");
		String cpwd = request.getParameter("Confirm_Pass");
		
		BaseServiceInt logins = new BaseService();
		User user = logins.getUserDetails(users);
		
		if(user != null) {
			if (npwd.equals(cpwd)) {
                    logins.updatePassword(users, npwd);
                    request.getSession().setAttribute("authorized", "true");
                    request.getSession().setAttribute("passwordmessage", "Password Updated Successfully");
                    message = "Success";
               
            }else {
            	request.getSession().setAttribute("authorized", "false");
                request.getSession().setAttribute("passwordmessage", "Password does not match");
                message = "Password does not match";
            }
		}else {
			request.getSession().setAttribute("authorized", "false");
			request.setAttribute("msgs", "No Such user exists ");
		}
		System.out.println(message);
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
