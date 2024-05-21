package com.chainsys.studentdao;

import java.sql.SQLException;

import com.chainsys.studentmodel.Student;

public interface StudentDAO {
	public void saveStudent(Student student)throws ClassNotFoundException, SQLException ;
}
