<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="com.chainsys.studentmodel.Student" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background-image: url("backgrounds.webp");
	background-repeat: no-repeat;
	background-size: cover;
}
    table {
        border-collapse: collapse;
        width: 73%;
        margin-top: 200px;
        margin-left: 179px;
    }

    td {
        border: 2px solid #ddd;
        padding: 8px;
        margin-top: 500px;
    }
	
	.search-button{
	margin : 20px 0px;
	}
	
	.button-container{
	position: absolute;
    top: 19%;
    right: 14%;
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
<% 
ArrayList<Student> student =(ArrayList<Student>)request.getAttribute("list1");
if (student != null && !student.isEmpty()) {
    for (Student obj : student) {
%>
<tr>
    <td><%= obj.getName() %></td>
    <td><%= obj.getMailId() %></td>
    <td><%= obj.getPhoneNumber() %></td>
    <td>
       <form action="DeleteStudent" method="get">
            <input type="hidden" class="delete-button" value=<%=obj.getName()%> name="Name">
            <input type="submit" class="delete-button" value="Delete" name="action">
        </form>
    </td>
    	
    <td>
    <button><a href="edit.html" style="text-decoration:none; color:black;">Edit</a> </button>
    
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="6">No users found</td>
</tr>
<%
}
%>
</table>
<div class="button-container">
<form action="SearchServlet" method="get">         
 		<input type="text" name="Name" id="Search" placeholder="Search ">
 	    <input type="submit" class="search-button" value="search" name="action">
	<button class="search-button"><a href="insert.html" class="add-user-link" style="text-decoration:none; color:black;">Add User</a></button>
</form>
<button><a href="LogoutSessions" style="text-decoration:none; color:black">Logout</a></button>
</div>
</body>
</html>