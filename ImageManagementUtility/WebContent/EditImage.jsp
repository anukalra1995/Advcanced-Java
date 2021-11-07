<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Images</title>
	</head>
	<body>
		<div align="center">
			<h1>Edit Image Details</h1>
		</div>
		<div class="container">
			<form method="POST" action = 'updateimg' enctype="multipart/form-data">
				<div class="form-group col-sm-5">
					<label for="name">SELECT IMAGE:</label><br><br>
					<input type="file" name="updateimages" class="form-control" required><br>
				</div>
				<br><br>
				<div class="form-group col-sm-10">
					<button type="submit"style="margin-left:40%">Update</button>
				</div>
			</form>
		</div>
	</body>
</html>