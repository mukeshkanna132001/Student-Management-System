package com.web.sms.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.sms.Entity.Student;
import com.web.sms.Repository.StudentRepository;
import com.web.sms.Service.StudentService;

@Service
public class Serviceimpl implements StudentService{
	
	private StudentRepository studentrepository;
	
	

	public Serviceimpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}



	@Override
	public List<Student> getAllStudents() {

		return studentrepository.findAll();
	}



	@Override
	public Student saveStudent(Student student) {

		return studentrepository.save(student);
	}



	@Override
	public Student updateStudent(Student student) {
		
		return studentrepository.save(student);
	}



	@Override
	public Student getStudentbyId(long id) {
		return studentrepository.findById(id).orElseThrow(null);
	}



	@Override
	public void deletestudent(long id) {
		
		 studentrepository.deleteById(id);
	}



	@Override
	public Student findByemail(String email) {
		return studentrepository.findByemail(email);
	}



	@Override
	public List<Student> searchStudents(String keyword) {
		
		return studentrepository.findByFirstnameContainingIgnoreCaseOrEmailContaining(keyword, keyword);
	}




	

}
