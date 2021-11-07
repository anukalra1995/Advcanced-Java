<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Image Management Utility</title>
		
		<!-- For Styling Html file -->
		<link rel="stylesheet" href="Css/HomeStyling.css">

	</head>
	<body>
	<!-- For File Extension Validation -->
		<script src="Javascripts/FileExtend.js" charset="utf-8"></script>
	<!-- Home Page Starts here -->
	
		<div class="container-fluid">
			<div class="navbar-header">
				<span class="images">
					<b>Image Management Utility</b>
				</span>
				
				<span style="float:right;">
					<a href="Login.jsp">Logout</a>
				</span>
			</div>
		</div>
		<br>
	
	<!-- Form for uploading Images Starts here -->
		<form action="uploadimg" method="POST" enctype="multipart/form-data" onsubmit="return Validate(this);">
			<div class="container">
				<div>
					Please select an image file to upload (Max size 1Mb)
					<br><br>
					<span >
						<input type="file" name="imageupload" class = "upload" value="Browse.." size="60%"required/>
					</span>
				</div>
		<!-- JSP CODE for printing Messages -->
			<% 
			if (session.getAttribute("authorized") != null ){ 						
				String message = session.getAttribute("msgs").toString();
			%>
			<p id="invalids">
				<%=message%>
			</p>
       		<% 
        		session.setAttribute("authorized", null);
           		}
       		%>
				<br>
				<div class="buttons">
						<input type="submit" value="Submit"	/>
						<input type="submit" value="Cancel"	/>
				</div>
			</div>
		</form>
		
		
	<!-- Code For List,Edit,Deleting Images For particular User -->
		<div>
			<div>
				<h4>Uploaded Images</h4>
			</div>
			<p id="invalids" style="text-align:center;">
				<%
					if(session.getAttribute("files") != null){
						out.println(request.getSession().getAttribute("messages"));
					}
					if(session.getAttribute("success") == "true"){
						out.println("Image of Id: "+request.getSession().getAttribute("imageIds")+" is "+request.getSession().getAttribute("imagereq"));
						request.setAttribute("success",null);
					}
				%>
		</p>
		
			<div class="table-responsive">
				<table>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>Size</th>
							<th>Preview</th>
							<th>Actions</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<c:forEach items = "${imageList}" var="images">
								<tr>
									<td>${images.imageId}</td>
									<td>${images.imageName}</td>
									<td>${images.imageSize}</td>
									<td>
										<img src="image-name?id=${images.imageId}" alt ="${images.imageName}" width="100px" height="100px">
									</td>
									<td>
										<a href="editimage?id=${images.imageId}"class="btn btn-outline-success" role="button">
											Edit
										</a>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="deleteimage?id=${images.imageId}" class="btn btn-outline-danger"role="button">
											Delete
										</a>
									</td>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>