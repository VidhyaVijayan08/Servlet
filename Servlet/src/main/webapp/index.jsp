<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.training.Employee" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
table{
border-collapse:collapse;
width:50%;
background-color:grey;
margin-top:200px;
margin-left:200px;
}
td{
border:2px solid#ddd;
padding:8px;
margin-top:500px;
}
</style>
</head>
<body>

<table>
<tr>
 <td>Name</td>
 <td>PhoneNumber</td>
 <td>Role</td>
 <td>Address</td>
 <td>UserName</td>
 <td>Password</td>
 
</tr>
<% ArrayList<Employee> list =( ArrayList<Employee>) request.getAttribute("list");
for(Employee obj:list){
%>
<tr>
<td><%= obj.getName()%></td>
<td><%= obj.getPhoneNumber()%></td>
<td><%= obj.getRole()%></td>
<td><%= obj.getAddress()%></td>
<td><%= obj.getUserName()%></td>
<td><%=obj.getPassword() %></td>
<%
}
    %>
</table>
</form>
</body> 
</html>