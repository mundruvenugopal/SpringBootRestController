package com.example.demo.curdoperations.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.curdoperations.entity.Student;
import com.example.demo.curdoperations.model.StudentRequestDTO;
import com.example.demo.curdoperations.model.StudentResponseDTO;
import com.example.demo.curdoperations.service.StudentService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") 
public class StudentController {
   @Autowired
   private StudentService studentService;
   @PostMapping("/process")
   public ResponseEntity<String> saveStudent(
           @Valid @RequestBody StudentRequestDTO studentRequest,
           BindingResult bindingResult) {

       if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().body("Validation errors occurred.");
       }
       studentService.saveStudent(studentRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully.");
   }

   @GetMapping("/")
   public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
       List<StudentResponseDTO> students = studentService.getAllStudents();
       
       if (students.isEmpty()) {
           return ResponseEntity.noContent().build(); 
       }
       
       return ResponseEntity.ok(students);
   }

   @GetMapping("/update/{id}")
   public ResponseEntity<Student> showFormForUpdate(@PathVariable Long id) {
       Student responseDTO = studentService.findStudentById(id);
       
       if (responseDTO == null) {
           return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(responseDTO);
   }

   @PutMapping("/update")
   public ResponseEntity<String> saveUpdatedData(@Valid @RequestBody StudentRequestDTO studentRequestDTO, BindingResult bindingResult) {

       if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().body("Validation errors occurred.");
       }

       try {
           studentService.saveUpdatedStudent(studentRequestDTO);
           return ResponseEntity.ok("Student updated successfully.");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student.");
       }
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> delete(@PathVariable Long id) {
       try {
           studentService.deleteStudent(id);
           return ResponseEntity.ok("Student deleted successfully.");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting student.");
       }
   }
}