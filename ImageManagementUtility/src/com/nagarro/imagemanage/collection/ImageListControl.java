package com.nagarro.imagemanage.collection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nagarro.imagemanage.hibernateutil.HibernatUtil;
import com.nagarro.imagemanage.models.ImageDetails;

/**
 * @author anukalra
 *
 *This servlet is responsible for Listing all the Images into screen from db
 */
@WebServlet("/image-name")
public class ImageListControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		
		try(Session sessions = HibernatUtil.getSession()) {
			
			ImageDetails images = sessions.get(ImageDetails.class, Integer.parseInt(request.getParameter("id")));
			ServletOutputStream cs = response.getOutputStream();
			cs.write(images.getImage());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
