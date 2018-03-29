<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Your Pet</title>
</head>
<h1>Doggy Chic</h1>
<body>
	<p>Please select correct pet:</p>
	<form method = "post" action = "addCustomerServlet">
	<table>
	<c:forEach items = "${requestScope.matchingPets}" var = "currentpet">
	<tr>
		<td><input type="radio" name="id" value="${currentpet.id}"></td>
		<td>${currentpet.petName}</td>
		<td>${currentpet.weight}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Select Pet" name = "doThisToItem">
	<input type = "submit" value = "New Pet" name = "doThisToItem">
	</form>
</body>
</html>