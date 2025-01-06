package com.example.demo.pojotojson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobalExceptionHandling {
	//if id is > studentid or less than studentid
		@ExceptionHandler
		public ResponseEntity<StudentErrorMessage> handleException(StudentNotFoundException exc) {
		StudentErrorMessage error = new StudentErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		//if id is incorrect type
		@ExceptionHandler
		public ResponseEntity<StudentErrorMessage> handleException(Exception exc) {
		StudentErrorMessage error = new StudentErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
}
