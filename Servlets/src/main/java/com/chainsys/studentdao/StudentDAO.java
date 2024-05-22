package com.chainsys.studentdao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.studentmodel.Student;

public interface StudentDAO{
	public void saveStudent(Student student)throws ClassNotFoundException, SQLException ;
	
	public void deleteStudent(Student student)throws ClassNotFoundException, SQLException;

	public void updateStudent(String name) throws ClassNotFoundException, SQLException;
	
	public void readStudent(Student student) throws ClassNotFoundException, SQLException;
	public static List<Student> retriveDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
