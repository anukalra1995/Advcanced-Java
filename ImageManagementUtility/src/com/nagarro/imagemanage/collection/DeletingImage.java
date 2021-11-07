package com.nagarro.imagemanage.collection;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imagemanage.models.ImageDetails;
import com.nagarro.imagemanage.services.ImageManagingService;

@WebServlet("/deleteimage")
public class DeletingImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		ImageManagingService imageManage = new ImageManagingService();
		
		String imageId = request.getParameter("id").toString();
		imageManage.deleteImage(imageId);
		
		request.getSession().setAttribute("success", "true");
		request.getSession().setAttribute("imageIds", imageId);
		request.getSession().setAttribute("imagereq", "deleted");
		
		String usernames = (String) request.getSession().getAttribute("username");
		ImageManagingService imageserve = new ImageManagingService();
		List<ImageDetails> allImageOfUser = imageserve.getAllImageOfUser(usernames);
		request.getSession().setAttribute("imageList", allImageOfUser);
		
		response.sendRedirect("Home.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
