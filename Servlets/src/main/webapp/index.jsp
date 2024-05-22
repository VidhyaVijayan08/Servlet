<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.chainsys.studentmodel.Student" %>
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
background-color: cornflowerblue;
margin-top:200px;
margin-left:200px;
}
a {
    text-decoration: none;
    color: black;
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
 <td>Email</td>
 <td>PhoneNumber</td>
 <td colspan="2">Update</td>
 
</tr>
<% ArrayList<Student> list =( ArrayList<Student>) request.getAttribute("list");
for(Student obj:list){
%>
<tr>
<td><%= obj.getName()%></td>
<td><%= obj.getMailId()%></td>
<td><%= obj.getPhoneNumber()%></td>
<td><a href="edit.html">Edit</a></td>
<td><a href="delete.html">Delete</a></td>
<%
}
%>
</table>
</form>

</body> 
</html>