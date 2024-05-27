package com.chainsys.studentmodel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.studentdao.StudentImpl;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "SearchServlet", urlPatterns = { "/SearchServlet" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student = new Student();
	StudentImpl studentImpl = new StudentImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String name= request.getParameter("Name");
		 student.setName(name);
		try 
	        {
	            List<Student> list1 = studentImpl.searchStudent(student);
	            request.setAttribute("list1", list1);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } 
	        catch (ClassNotFoundException | SQLException e)
	        {
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
