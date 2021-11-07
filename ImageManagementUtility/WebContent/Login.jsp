<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Form</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="Css/LoginStyling.css">
	</head>
	
	<body>
	<!-- Login Form -->
		<form action="Login" method="POST">
			<div class="container">
				<h3>Login</h3>
				<% 
					if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false")){ 
						
				%>
       			 
       			 <p id="invalids">
       			 	Invalid credentials 
       			 	<br/>
       			
        		<% 
        			out.print("\t\t"+request.getAttribute("msg"));
        			session.setAttribute("authorized", null);
           			} 
       			 %>
       			 </p>
				<div class="container">
					<div  id="userpass">
						<span class = "labels">UserName:</span> 
							<span class="required">*</span> 
							<input type="text" name="username" placeholder="Enter Username" size = "50" required/>
					</div>
					<br>
					<div  id="userpass">
						<span class="labels">Password       </span> 
							<span class="required">*</span> 
							<input type="Password" name="password" placeholder="Enter Password" size="50" required/>
					</div>
					<br>
					<div class = "links">
						<a href="#myModal" data-toggle="modal">Forgot Password</a>
					</div>
					
					<div class = "buttons">
						<input type="submit" value="Login" />
					</div>
				</div>
			</div>
		</form>
		
	<!-- For Forgot Password -->
		
		<!-- Modal -->
		<div class = "modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				
				<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							&times;</button>
						<h4 class="modal-title">Change Password</h4>
					</div>
					<div class="modal-body">
						<form action="PasswordController" method="post">
							<div>
								<span class = "labels"> Confirm UserName</span>
								<input type="text" name="UserName" placeholder="Confirm Username" required size = "50">
							</div>
							<br />
							<div>
								<span class = "labels">New Password:</span>
								<input type="password" name="New_Pass" id="passwordnew" placeholder="New Password" required size = "50"> 
							</div>
							<br /> 
							<div>
								<span class = "labels">Confirm Password:</span>
								<input type="password" name="Confirm_Pass" id="passwordnewconfirm" placeholder="Confirm Password" required size = "50">
							</div>
							<br /> 
							<div align = "center">
								<input type="submit" value="Change Password">
							</div>
							<span id='message'>
								<% 
									if (session.getAttribute("authorized") != null ){
										String message = session.getAttribute("passwordmessage").toString();
								%>
									<%=message%>
								<% 
									session.setAttribute("authorized", null);
									}
								%>
							</span>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Close
						</button>
					</div>
				</div>
				
			</div>
		</div>
		
	</body>
</html>