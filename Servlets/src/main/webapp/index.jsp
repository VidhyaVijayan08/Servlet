<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="com.chainsys.studentmodel.Student" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    table {
        border-collapse: collapse;
        width: 73%;
        background-color: white;
        margin-top: 200px;
        margin-left: 179px;
    }

    td {
        border: 2px solid #ddd;
        padding: 8px;
        margin-top: 500px;
    }
</style>
</head>
<body>

<table>
<tr>
    <td>name</td>
    <td>email</td>
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
        <form action="UpdateStudentServlet" method="post">
 		    <input type="hidden" name="update" value=<%=obj.getPhoneNumber()%>>
           <button> <a href="edit.html?editPhoneNumber=<%=obj.getPhoneNumber()%>" class="edit-button" style="text-decoration:none; color:black;">Edit</a></button>   
        </form>
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
<button><a href="insert.html" class="add-user-link" style="text-decoration:none; color:black;">Add User</a></button>
</body>
</html>