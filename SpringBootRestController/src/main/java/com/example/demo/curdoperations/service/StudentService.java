package com.example.demo.curdoperations.service;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.curdoperations.entity.Student;
import com.example.demo.curdoperations.model.StudentRequestDTO;
import com.example.demo.curdoperations.model.StudentResponseDTO;
import com.example.demo.curdoperations.repository.StudentRepository;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository; 
    private static final Logger logger = Logger.getLogger(StudentService.class);

    public void saveStudent(StudentRequestDTO studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setPhNo(studentRequest.getPhNo());
        logger.debug("Saving student: " + student);
        studentRepository.save(student); 
        logger.info("Saved new student: " + student.getFirstName() + " " + student.getLastName());
    }

   public List<StudentResponseDTO> getAllStudents() {
       List<Student> students = studentRepository.findAllByOrderByIdAsc();
       List<StudentResponseDTO> studentResponseDTOs = new ArrayList<>(); 
       for (Student student : students) {
           StudentResponseDTO dto = StudentResponseDTO.builder()
                   .id(student.getId())
                   .firstName(student.getFirstName())
                   .lastName(student.getLastName())
                   .email(student.getEmail())
                   .phNo(student.getPhNo())
                   .build();
           studentResponseDTOs.add(dto);
       }
       return studentResponseDTOs; 
   }

   public Student findStudentById(Long id) {
       return this.studentRepository.findStudentById(id);
   }

   public void saveUpdatedStudent(StudentRequestDTO studentRequestDTO) {
       int updatedRows = this.studentRepository.updateStudent(
               studentRequestDTO.getId(),
               studentRequestDTO.getFirstName(),
               studentRequestDTO.getLastName(),
               studentRequestDTO.getEmail(),
               studentRequestDTO.getPhNo());

       if (updatedRows > 0) {
           logger.info("Updated successfully");
       } else {
           logger.warn("No record found to update");
       }
   }

   public void deleteStudent(Long id) {
       int deletedRows = this.studentRepository.deleteStudentById(id);
       
       if (deletedRows > 0) {
           logger.info("Deleted successfully");
       } else {
           logger.warn("No record found to delete");
       }
   }

   public boolean existsById(Long id) {
       return this.studentRepository.existsById(id);
   }
}