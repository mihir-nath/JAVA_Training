<%@page import="service.DepartmentServiceImplimentation"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entities.Department"%>
<%@page import="java.util.List"%>
<%@page import="service.DepartmentServiceImplimentation"%>
<%@page import="service.DepartmentService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Showing all the Departments </h1>
	
	<%
		DepartmentService deptService = new DepartmentServiceImplimentation();
		List<Department> deptList = deptService.findDepartmentService();
	%>
	
	<table border=5 cellspacing=10 cellpadding=10>
		<tr>
			<th> DEPT NO </th>
			<th> DEPT NAME </th>
			<th> DEPT LOCATION </th>
		</tr>
		
	<%
		for(Department dept : deptList) {
	%>
		<tr>
			<td> <%=dept.getDepartmentNumber() %></td>
			<td> <%=dept.getDepartmentName()   %></td>
			<td> <%=dept.getDepartmentLocation() %></td>
		</tr>
	<% } %>
	</table>
	
	<a href="index.html"> Go Back Home</a>
	
</body>
</html>