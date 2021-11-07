<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Employee Details</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link href="<c:url value="/resources/EditStyle.css" />" rel="stylesheet" >
		<script src="<c:url value="/resources/Validate.js" />"></script>
	</head>
	<body>
	<%
		if(request.getSession().getAttribute("username")==null){
			response.sendRedirect("Login");
		}
	%>
		<nav class="navbar navbar-default">
			<div class="header">
				<span class="navbar-header" style="margin-left:35%;font-weight: bold;font-size:25px;">
					<a class="navbar-brand" href="Home">HR MANAGEMENT</a>
				</span>
				<span class="nav navbar-nav navbar-right" style="font-size:25px;margin-right:10px;">
					Welcome <%=(String)request.getSession().getAttribute("username") %>
					<a href="Login">
          				<i class="material-icons " style="background-color:yellow;color:red;">close</i>
          			</a>
				</span>
			</div>
		</nav>
		<div>
			<form name="EditForm"action="editform" method="post">
				<fieldset>
					<legend>Edit Employee Details</legend>
					<div class="refers">
						<label for="empcode">Employee Code: </label>
						<input type="text" id="empcode" name="empcode" value="${employee.empcode}" readonly/>
					</div>
					<div class="clear"></div>
					<div class="refers">
						<label for="empname">Employee Name</label>
						<input type="text" id="empname" name="empname" value="${employee.empname}" required/>
					</div>
					<div class="clear"></div>
					<br/>
					<div class="refers">
						<label for="emploc">Location</label>
						<input type="text" id="emploc" name="emploc" value="${employee.emploc}" required/>
					</div>
					<div class="clear"></div>
					<br />
					<div class="refers">
						<label for="empmail">Email Id</label>
						<input type="email" id="empmail" name="empmail" width="50%" value="${employee.empmail}" required/>
					</div>
					<div class="clear"></div>
					<br />
					<div class="refers">
						<label for="empdob">Date Of Birth</label>
						<input type="date" id="empdob" name="empdob" width="50%" value="${employee.empdob}" required/>
					</div>
					<div class="clear"></div>
					<br />
					<div>
						<span>
							<input type="submit" class="button" value="Save" onclick="valideditform()"/>
						</span>
						<span>
							<input type="reset" class="button" value="Cancel"/>
						</span>
						
					</div>
				</fieldset>
			</form>
		</div>
		<div class="footer">
			
		</div>
	</body>
</html>