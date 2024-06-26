package com.chainsys.studentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import com.chainsys.bloodbankutil.ConnectionUtil;
import com.chainsys.studentmodel.Student;
import com.chainsys.studentutil.ConnectUtil;

public class StudentImpl implements StudentDAO{
	Student student = new Student();
	
	public void saveStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection con = ConnectUtil.getConnection();
        String addStudent = "insert into student(name, mailid, phonenumber)values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(addStudent);
       
       
            student.setName(student.getName());
            System.out.println("Getting Student name" + student.getName());
            ps.setString(1, student.getName());
            ps.setString(2, student.getMailId());
            ps.setString(3, student.getPhoneNumber());
            System.out.println("Setting Student name : " + student.getName());
            int rows = ps.executeUpdate();
            System.out.println("In Add movie Servlet.." + rows);
        }

	public void deleteStudent(Student student) throws ClassNotFoundException, SQLException {
		Connection con = ConnectUtil.getConnection();
		String save="delete from  student where name=?";
        PreparedStatement prepareStatement = con.prepareStatement(save);
        prepareStatement.setString(1, student.getName());
        int rows = prepareStatement.executeUpdate();
    	System.out.println(rows + " deleted");
	}
	
	

	public void updateStudent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
			  Scanner sc = new Scanner(System.in); 
			  Connection connection = ConnectUtil.getConnection();
		      String save="UPDATE student SET name=? WHERE phonenumber=?";
		      PreparedStatement prepareStatement = connection.prepareStatement(save);
		      prepareStatement.setString(1,"Name");
		      prepareStatement.setString(2, "PhoneNumber");
		     
		      int rows = prepareStatement.executeUpdate();
		      System.out.println(rows+" updated");
		  
	}

	public static List<Student> retriveDetails() throws ClassNotFoundException, SQLException 
    {
        ArrayList<Student> list=new ArrayList<>();
        Connection connection=ConnectUtil.getConnection();
        String select="select name,mailid,phonenumber from student";
        PreparedStatement prepareStatement=connection.prepareStatement(select);
        ResultSet resultSet=prepareStatement.executeQuery();
        while(resultSet.next())
        {
            String name=resultSet.getString(1);
            String email=resultSet.getString(2);
            String phoneNumber=resultSet.getString(3);
            Student student=new Student();
            student.setName(name);
            student.setMailId(email);
            student.setPhoneNumber(phoneNumber);
            list.add(student);
        }
        connection.close();
        return list;
    }
	
	public void readStudent(Student student) throws ClassNotFoundException, SQLException {
		  	Connection connection = ConnectUtil.getConnection();
	        System.out.println(connection);
	        String save="SELECT  id,mailid,phonenumber FROM student";
	        PreparedStatement prepareStatement = connection.prepareStatement(save);
	        Statement stmt = connection.createStatement();
	    	ResultSet rows = stmt.executeQuery(save); 
	    	while (rows.next()) {
	            String name = rows.getString("Name");
	            String mailId = rows.getString("MailId");
	            String phoneNo = rows.getString("PhoneNumber");
	            System.out.println("Retrieved Data");
	            System.out.println("__________________________________________________________________________________");
	            System.out.println("Name : " + name + "\t\t Email : " + mailId  + "\t\t PhoneNumber : " + phoneNo);
	            System.out.println("__________________________________________________________________________________");
	    	}
	        System.out.println(rows+" retrieved");
	}
	
	
	public List<Student> searchStudent(Student student) throws ClassNotFoundException, SQLException {
        ArrayList<Student> list=new ArrayList<>();
	  	Connection connection = ConnectUtil.getConnection();
        System.out.println(connection);
        String save="SELECT  name,mailid,phonenumber FROM student where name=?";
        PreparedStatement prepareStatement = connection.prepareStatement(save);
        prepareStatement.setString(1, student.getName());
        Statement stmt = connection.createStatement();
    	ResultSet rows = prepareStatement.executeQuery(); 
    	while (rows.next()) {
            String name = rows.getString("Name");
            String mailId = rows.getString("MailId");
            String phoneNo = rows.getString("PhoneNumber");
//            System.out.println("Retrieved Data");
//            System.out.println("__________________________________________________________________________________");
//            System.out.println("Name : " + name + "\t\t Email : " + mailId  + "\t\t PhoneNumber : " + phoneNo);
//            System.out.println("__________________________________________________________________________________");
    		student.setName(name);
    	    student.setMailId(mailId);
    	    student.setPhoneNumber(phoneNo);
            list.add(student);
    	
    	}
        System.out.println(rows+" retrieved");
		return list;
}

	  
}
//}
