package com.web.sms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.sms.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByemail(String email);
	
	List<Student> findByFirstnameContainingIgnoreCaseOrEmailContaining(String firstname , String email);


}
