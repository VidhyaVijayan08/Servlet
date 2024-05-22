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
 * Servlet implementation class UpdateStudent
 */
@WebServlet(name = "UpdateStudent", urlPatterns = { "/UpdateStudent" })
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Student> list = new ArrayList<>();
	 Student student = new Student();
     StudentImpl studentImpl = new StudentImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
	        student.setName(name);
	        String mailId = request.getParameter("Email");
//	        student.setMailId(mailId);
	        String phoneNumber = request.getParameter("PhoneNumber");
	        student.setPhoneNumber(phoneNumber);
//	        list.add(new Student(name,mailId,phoneNumber));
	        try {
	            studentImpl.updateStudent();
	            PrintWriter writer = response.getWriter();
	            writer.println(name + " updated");
	            writer.println(student.getPhoneNumber());
	        } catch (ClassNotFoundException | SQLException e) {
	            // TODO Auto-generated catch block
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
