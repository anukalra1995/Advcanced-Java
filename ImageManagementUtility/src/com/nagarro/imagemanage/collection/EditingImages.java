package com.nagarro.imagemanage.collection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imagemanage.models.ImageDetails;
import com.nagarro.imagemanage.services.ImageManagingService;

@WebServlet("/editimage")
public class EditingImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ImageManagingService imageManage = new ImageManagingService();
		
		int imageId = Integer.parseInt(request.getParameter("id"));
		
		ImageDetails img = imageManage.getImageById(imageId);
		request.getSession().setAttribute("image",img);
		
		request.getRequestDispatcher("EditImage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
