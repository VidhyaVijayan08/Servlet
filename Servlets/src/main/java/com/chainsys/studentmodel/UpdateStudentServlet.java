package com.chainsys.studentmodel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.studentdao.StudentImpl;
import com.chainsys.studentutil.ConnectUtil;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentImpl studentImpl = new StudentImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String name = request.getParameter("Name");
	    String mailId = request.getParameter("Email");
	    String phoneNumber = request.getParameter("PhoneNumber");
	    Student student = new Student();
	    student.setName(name);
	    System.out.println(name);
	    student.setMailId(mailId);
	    student.setPhoneNumber(phoneNumber);
	    System.out.println(phoneNumber);

	    try {
	    	updateStudent(student);
	        List<Student> list1 = StudentImpl.retriveDetails();
            request.setAttribute("list1", list1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    	    dispatcher.forward(request, response);
	  
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(); 
	    }
	}

	
	    public static void updateStudent(Student student) throws ClassNotFoundException, SQLException {
	    	System.out.println(student.getName());
	        Connection connection = ConnectUtil.getConnection();
	        String updateQuery = "UPDATE student SET name = ? WHERE phonenumber = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, student.getName());
	        preparedStatement.setString(2, student.getPhoneNumber());
		    int rows = preparedStatement.executeUpdate();
		    System.out.println(rows+" updated");
	        connection.close();
	    }
	}


