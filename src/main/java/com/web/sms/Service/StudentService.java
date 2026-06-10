package com.web.sms.Service;

import java.util.List;

import com.web.sms.Entity.Student;

public interface StudentService {

	List <Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentbyId(long id);
	
	Student updateStudent(Student student);
	
	void deletestudent(long id);
	
	Student findByemail(String email);
	
	List<Student> searchStudents(String keyword);
}
