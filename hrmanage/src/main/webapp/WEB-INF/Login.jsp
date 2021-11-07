<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Login Form</title>
		<link rel="shortcut icon" href="/favicon.ico">
		<link href="<c:url value="/resources/style.css" />" rel="stylesheet" >
		<script src="<c:url value="/resources/Validating.js" />"></script>
	</head>
	<body>
		<div class="header">
			
		</div>
		<div>
			<form name="myForm"action="Home" method="post">
				<fieldset>
					<legend>Log in</legend>
					<div class="refers">
						<label for="login">User Id</label>
						<input type="text" id="login" name="username" required/>
					</div>
					<div class="clear"></div>
					<div class="refers">
						<label for="password">Password</label>
						<input type="password" id="password" name="password" required/>
					</div>
					<div class="clear"></div>
					
					<br />
					<div >
						<input type="submit" class="button" value="Log in" onclick="validform()"/>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="footer">
			
		</div>
	</body>
</html>