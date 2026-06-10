package com.web.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.sms.Entity.Student;
import com.web.sms.Repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
	private StudentRepository studentrepo;
	
	@Override
	public void run(String... args) throws Exception {
		
	    if(studentrepo.count() == 0) {

	  Student student1 = new Student("Mukesh", "Kanna", "mukesh132001@gmail.com");
		studentrepo.save(student1);
		

		Student student2 = new Student("Vijay", "Sekar", "vijay132001@gmail.com");
		studentrepo.save(student2);
		

		Student student3 = new Student("Viji", "Kanna", "vijai132001@gmail.com");
		studentrepo.save(student3);
		
	    }
	
	}
}
