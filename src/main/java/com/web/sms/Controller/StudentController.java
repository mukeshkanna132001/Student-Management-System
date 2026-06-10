package com.web.sms.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.sms.Entity.Student;
import com.web.sms.Service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	
	@GetMapping("/students")
	public String liststudents(Model model)
	{
		
		List<Student> students = studentservice.getAllStudents();
		model.addAttribute("students" , students);
		model.addAttribute("count", students.size());
		return "students";
	} 
	
	
	@GetMapping("/students/new")
	public String CreateNewStudent(Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	
	@PostMapping("/students")
	public String  savestudent(@Valid @ModelAttribute("student") Student student, BindingResult result)
	{
		
		Student existingstudent = studentservice.findByemail(student.getEmail());
		
		if(existingstudent != null)
		{
			result.rejectValue("email",null,"Email already exists");
		}
		if(result.hasErrors())
		{
			return "create_student";
		}
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable long id, Model model)
	{
		model.addAttribute("student", studentservice.getStudentbyId(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(  @PathVariable long id,@Valid @ModelAttribute("student") Student student , BindingResult result)
	{
		Student existsstudent = studentservice.getStudentbyId(id);
		Student existingEmail =
		        studentservice.findByemail(student.getEmail());

		if(existingEmail != null &&
		   existingEmail.getId() != id)
		{
		    result.rejectValue(
		        "email",
		        null,
		        "Email already exists");
		}
		if(result.hasErrors())
		{
			return "update_student";
		}
		existsstudent.setFirstname(student.getFirstname());
		existsstudent.setSecondname(student.getSecondname());
		existsstudent.setEmail(student.getEmail());
		studentservice.updateStudent(existsstudent);
		return "redirect:/students";
		
	}
	
	
	@GetMapping("/students/delete/{id}")
	public String deletestudent(@PathVariable long id)
	{
		studentservice.deletestudent(id);	
		return "redirect:/students";
	}
	
	@GetMapping("/students/search")
	public String searchStudents(@RequestParam("keyword") String keyword, Model model)
	{
	    model.addAttribute("students", studentservice.searchStudents(keyword));
        return "students";
	}

}
