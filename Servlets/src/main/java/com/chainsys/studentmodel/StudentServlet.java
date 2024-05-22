package com.chainsys.studentmodel;

import java.io.IOException;
import java.io.PrintWriter;
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


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Student> list = new ArrayList<>();
	Student student = new Student();
//    StudentImpl studentImpl = new StudentImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw =response.getWriter();
//		   int userId = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("Name");
	        String mailId = request.getParameter("Email");
	        String phoneNumber = request.getParameter("PhoneNumber");
	        
//	        pw.println(userId);
//	        pw.println(name);
//	        pw.println(phoneNo);
//	        pw.println(role);
//	        pw.println(address);
//	        pw.println(userName);
//	        pw.println(password);
//	        Employee employee = new Employee(userId,name,phoneNo,role,address,userName,password); 
	        try 
	        {
	            list=StudentImpl.retriveDetails();
	            System.out.println(list);
	            System.out.println("Displayed successfully..");
	        } 
	        catch (ClassNotFoundException | SQLException e)
	        {
	            e.printStackTrace();
	        }
	        list.add(new Student(name,mailId,phoneNumber));
		 request.setAttribute("list", list);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	     dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
