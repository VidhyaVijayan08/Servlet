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
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "DeleteStudent", urlPatterns = { "/DeleteStudent" })
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Student> list = new ArrayList<>();
	 Student student = new Student();
     StudentImpl studentImpl = new StudentImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
	        String name = request.getParameter("Name");
	        student.setName(name);
	      
	        try {
	            studentImpl.deleteStudent(student);
	            PrintWriter writer = response.getWriter();
	            writer.println(student.getName() + " deleted");
	        } catch (ClassNotFoundException | SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        
	        }
//	        list.add(new Student(name,mailId,phoneNumber));
//			 request.setAttribute("list", list);
//		     RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//		     dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
