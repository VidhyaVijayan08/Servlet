package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(name = "EmployeeServlets", urlPatterns = { "/EmployeeServlets" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Employee> list = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
//		   int userId = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("Name");
	        String phoneNumber = request.getParameter("PhoneNumber");
	        String role = request.getParameter("Role");
	        String address = request.getParameter("Address");
	        String userName = request.getParameter("Email");
	        String password = request.getParameter("Password");
	        
//	        pw.println(userId);
//	        pw.println(name);
//	        pw.println(phoneNo);
//	        pw.println(role);
//	        pw.println(address);
//	        pw.println(userName);
//	        pw.println(password);
//	        Employee employee = new Employee(userId,name,phoneNo,role,address,userName,password); 

	        list.add(new Employee(name,phoneNumber,role,address,userName,password));
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
