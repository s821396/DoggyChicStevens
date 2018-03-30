<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Pet Information</title>
<link rel="stylesheet" href="style.css" type="text/css">
<link rel="stylesheet"  href="https://fonts.googleapis.com/css?family=Satisfy">
</head>
<h1>Doggy Chic</h1>
<body>
	<form action = "editAppointmentServlet" method = "post">
	<div class = "form">
	Name: <input type = "text" name = "name" value = "${petToEdit.name}">
	</div>
	<br/>
	<div class = "form">
	Weight: <input type = "text" name = "weight" value = "${petToEdit.weight}">
	</div>
	<br/>
	<div class = "form">
	Has current vaccinations (Y/N): <input type = "text" name = "shots" value = "${petToEdit.hasShots}">
	</div>
	<br/>
	<input type = "hidden" name = "id" value = "${petToEdit.petID}">
	<div class = "link-button">
	<input type = "submit" value = "Save Pet Information" name = "doThisToItem">
	</div>
	<div class = "page-image">
	<img src = "images/dog3.jpg">
	</div>
	</form>
</body>
</html>