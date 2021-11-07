<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link href="<c:url value="/resources/HomeStyling.css" />" rel="stylesheet" >
	</head>
	<body >
	<!-- Home Page Starts here -->
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
				<fieldset>
					<legend>EmployeeList</legend>
					<div>
						<form action="upload" method="post">
							<button type="submit" class="button"  value="save">
							Download Employee Details
							</button>	
							<button type="submit" class="button" value="save">
								Upload Employee Details
							</button>		
						</form>	
					</div>
					<div class="clear"></div>
					<br />
					<div class="table-responsive">
						<table>
  							<thead>
  								<tr>
  									<th>Employee Code</th>
  									<th>Employee Name</th>
  									<th>Employee Location</th>
  									<th>Employee E-mail</th>
  									<th>Employee D.O.B</th>
  									<th>Actions</th>
  								</tr>  								
  							</thead>
  							<tbody>
  								<tr>
  									<c:forEach items = "${employees}" var = "employee">
									<tr class = "emp_row">
  										<td>${employee.empcode}</td>
  										<td>${employee.empname}</td>
  										<td>${employee.emploc}</td>
  										<td>${employee.empmail}</td>
  										<td>${employee.empdob}</td>
										<td>
											<a href="edit?id=${employee.empcode}"class="btn btn-outline-success" role="button">
												Edit
											</a>
										</td>
									</tr>
									</c:forEach>
  								</tr>
  							</tbody>
  						</table>
					</div>
				</fieldset>
			</div>
	</body>
</html>