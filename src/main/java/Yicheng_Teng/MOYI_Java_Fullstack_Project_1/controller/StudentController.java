package Yicheng_Teng.MOYI_Java_Fullstack_Project_1.controller;

import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.dto.StudentDto;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
       StudentDto savedStudent = studentService.createStudent(studentDto);
       return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // Build Get Student REST API
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }


    // Build Get All Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }



    // Build Update Student REST API
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent) {
        StudentDto updatedStudentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(updatedStudentDto);
    }



    // Build Delete Student REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student removed successfully.");
    }
}
