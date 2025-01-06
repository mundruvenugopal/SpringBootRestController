package com.example.demo.pojotojson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@RestController
@RequestMapping("/api")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Student {
	private int StudentId;
	private String FirstName;
	private String LastName;
	//@GetMapping("/student")
	@GetMapping("/students/{studentid}")
	public Student studentlist(@PathVariable int studentid) {
		List<Student>thestudent=new ArrayList<>();
		thestudent.add(new Student(1,"venu","gopal"));
		thestudent.add(new Student(2,"narendra","papasani"));
		//return thestudent;
		if(studentid>=thestudent.size()||(studentid<0))
		{
			throw new StudentNotFoundException("Student id not found_"+studentid);
		}
		return thestudent.get(studentid);
	}
	
}
