<%@page import="service.DepartmentServiceImplimentation"%>

<%@page import="java.util.List"%>
<%@page import="entities.Department"%>
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
	<%
		DepartmentService deptService = new DepartmentServiceImplimentation();
	
		int existingDeptNumber=Integer.parseInt(request.getParameter("dno")); //read from HTML
		
		
		deptService.removeDepartmentService(existingDeptNumber);
		
		
	%>
			<h2> Existing Department Deleted </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>