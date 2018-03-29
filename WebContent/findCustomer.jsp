<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Information</title>
</head>
<h1>Doggy Chic</h1>
<body>
	<p>Please select correct customer:</p>
	<form method = "post" action = "addCustomerServlet">
	<table>
	<c:forEach items = "${requestScope.matchingCustomers}" var = "currentcustomer">
	<tr>
		<td><input type="radio" name="id" value="${currentcustomer.id}"></td>
		<td>${currentcustomer.firstName}</td>
		<td>${currentcustomer.lastName}</td>
		<td>${currentcustomer.address}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Select Customer" name = "doThisToItem">
	<input type = "submit" value = "New Customer" name = "doThisToItem">
	</form>
</body>
</html>