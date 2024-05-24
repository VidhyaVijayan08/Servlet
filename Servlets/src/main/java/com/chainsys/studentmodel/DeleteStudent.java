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
	        String name = request.getParameter("Name");
	        student.setName(name);

	        try {
	            studentImpl.deleteStudent(student);
	            PrintWriter writer = response.getWriter();
	            writer.println(student.getName() + " deleted");
	            List<Student> list1 = StudentImpl.retriveDetails();
	            request.setAttribute("list1", list1);
	   	  
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        
	        }
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//        if (action != null) {
//            switch (action) {
//                case "add":
//                try {
//                    saveStudent(request, response);
//                } catch (ClassNotFoundException | ServletException | IOException e) {
//                    
//                    e.printStackTrace();
//                }
//                    break;
//                case "delete":
//                try {
//                    deleteStudent(request, response);
//                } catch (ClassNotFoundException | ServletException | IOException e) {
//                
//                    e.printStackTrace();
//                }
//                    break;
//            }
//        }
//	}

}
