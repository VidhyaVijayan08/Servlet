package com.training;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "FirstServlet", urlPatterns = {"/FirstServlet"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
        pw.println("<h1>Login Successful!</h1>");
        System.out.println("In Add Servlet");
        String name =request.getParameter("Name");
        PrintWriter out = response.getWriter();
        out.println(name);	
//        String phoneNo =request.getParameter("PhoneNumber");
//        int phoneNo1 =Integer.parseInt(request.getParameter("phoneNo1"));
        String gender = request.getParameter("Gender");
        out.println(gender);
        String email = request.getParameter("Email");
        out.println(email);
        String password = request.getParameter("Password");
        out.println(password);
//        out.println(phoneNo1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
