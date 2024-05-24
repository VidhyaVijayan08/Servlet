package com.chainsys.studentmodel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.studentdao.StudentImpl;

/**
 * Servlet implementation class SaveStudent
 */
@WebServlet(name = "SaveStudent", urlPatterns = { "/SaveStudent" })
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Student student = new Student();
       StudentImpl studentImpl = new StudentImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter pw =response.getWriter();
//		   int userId = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("Name");
	        student.setName(name);
	        String mailId = request.getParameter("Email");
	        student.setMailId(mailId);
	        String phoneNumber = request.getParameter("PhoneNumber");
	        student.setPhoneNumber(phoneNumber);
	       
	        try {
	            studentImpl.saveStudent(student);
	            List<Student> list1 = StudentImpl.retriveDetails();
	            request.setAttribute("list1", list1);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
