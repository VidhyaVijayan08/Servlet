package com.chainsys.studentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.studentmodel.Student;
import com.chainsys.studentutil.ConnectUtil;

public class StudentImpl implements StudentDAO{
	
	
	public void saveStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection con = ConnectUtil.getConnection();
        String addStudent = "insert into student(name, mailid, phonenumber)values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(addStudent);
       
       
        //if ((.trim().length() > 3) && (actor.trim().length() >= 5) && (actress.length() >= 5)) {
            student.setName(student.getName());
            System.out.println("Getting Student name" + student.getName());
        //    ps.setString(1, "3");//
            ps.setString(1, student.getName());
//            movie.setLength(movie.getLength());
            ps.setString(2, student.getMailId());
            ps.setString(3, student.getPhoneNumber());
            System.out.println("Setting Student name : " + student.getName());
            int rows = ps.executeUpdate();
            System.out.println("In Add movie Servlet.." + rows);
        //} else {
            //System.out.println("Invalid movie details");
        }        
}
//}
