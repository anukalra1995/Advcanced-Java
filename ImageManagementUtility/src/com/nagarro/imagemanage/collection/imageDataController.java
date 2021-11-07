package com.nagarro.imagemanage.collection;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imagemanage.models.ImageDetails;
import com.nagarro.imagemanage.models.User;
import com.nagarro.imagemanage.services.ImageManagingService;



@WebServlet("/retrieveimage")
public class imageDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		ImageManagingService imageservice = new ImageManagingService();
		List<ImageDetails> imageList = imageservice.getAllImageOfUser(user.getUsername());
		request.setAttribute("imageList", imageList);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
