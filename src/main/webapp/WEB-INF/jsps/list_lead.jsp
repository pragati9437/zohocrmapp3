<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads</title>
</head>
<body>
   <a href="viewCreatelead">new lead</a>
	<h2>List of all Leads</h2>
	<table border = '1'>
		<tr>
			<th>firstName</th>
			<th>lastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Source</th>
			<th>Update</th>		
		</tr>
			<c:forEach var = "lead" items = "${leads}">
		<tr>
		    <td><a href="leadinfo?id=${lead.id}">${lead.firstName}</a></td>
			
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.mobile}</td>	
			<td>${lead.source}</td>
			<td><a href="updateLead?id=${lead.id }">update</a></td>
		</tr>
			
			</c:forEach>
	</table>
</body>
</html>