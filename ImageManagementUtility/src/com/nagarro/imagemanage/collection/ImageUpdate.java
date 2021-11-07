package com.nagarro.imagemanage.collection;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.imagemanage.models.ImageDetails;
import com.nagarro.imagemanage.models.User;
import com.nagarro.imagemanage.services.ImageManagingService;

/**
 * Servlet implementation class ImageUpdate
 */
@WebServlet("/updateimg")
@MultipartConfig
public class ImageUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m,filename;		

		long filesize = 1 * 1024 * 1024,Totalfilesize = 1024*1024*10;
		double TotalSize = 0;
		
		ImageDetails images = (ImageDetails) request.getSession().getAttribute("image");
		InputStream is = null;
		
		Part part = request.getPart("updateimages");
		
		if(part != null) {
			
			/**
			 * Getting size of image and setting it in ImageDetails(persistence class)
			 */
			double imgsizes =((double)part.getSize()) /1024;
			images.setImageSize(imgsizes/1024);
			
			if(images.getImageSize() < filesize ) {
				
				/**
				 * Setting username into image table
				 */
				User user = (User)request.getSession().getAttribute("user");
				images.setUser(user);
				
				/**
				 * Getting Total Size of all images of particular user
				 */
				List<ImageDetails> imagelist = user.getImages();
				for(ImageDetails image : imagelist) {
					
					TotalSize += image.getImageSize();
					
				}
				System.out.println("Total size of all images: "+TotalSize);
				
				/**
				 * Checking whether input image is greater than 10 Mb or not
				 */
				
				if(TotalSize + images.getImageSize() - imgsizes < Totalfilesize) {
					
					System.out.println("True, It is less than 10 mb");
					
					/**
					 * Extracting Filename from image Path
					 */
					for (String cd : part.getHeader("content-disposition").split(";")) {
						
						if (cd.trim().startsWith("filename")) {
							
					        filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
					         m= filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
					        
					        images.setImageName(m.substring(0, m.indexOf('.')));		//Setting image name
						}
					}
					
					/**
					 * Setting Image to image(blob datatype)
					 */
					
					if(part!= null) 
						is=part.getInputStream();
					byte[] data = new byte[is.available()];
					is.read(data);				//Reading the data of byte format
					images.setImage(data);		//Setting image(blob)
					
					
						/**
						 * Saving image during Session and transaction
						 */
						try {
							
							ImageManagingService imageserve = new ImageManagingService();
							
							imageserve.updateImage(images);
							
							
							List<ImageDetails> allImageOfUser = imageserve.getAllImageOfUser(user.getUsername());
							request.getSession().setAttribute("imageList", allImageOfUser);
							System.out.println("Updated");
							
							request.getSession().setAttribute("files", "true");
							request.getSession().setAttribute("messages", "File is Updated");
							System.out.println(request.getSession().getAttribute("msgs"));
							
							
						} catch (Exception e) {
							
							request.getSession().setAttribute("files", "false");
							request.getSession().setAttribute("messages", "Problem");
							System.out.println(request.getSession().getAttribute("messages"));
						}
				}
			}else {
				request.getSession().setAttribute("files", "false");
				request.getSession().setAttribute("messages", "File Size exceeded than 1Mb");
				System.out.println(request.getSession().getAttribute("messages"));
				
			}
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		
	}
}
