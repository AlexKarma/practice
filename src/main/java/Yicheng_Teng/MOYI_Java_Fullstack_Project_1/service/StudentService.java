package Yicheng_Teng.MOYI_Java_Fullstack_Project_1.service;

import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.dto.StudentDto;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto updatedStudentDto);

    void deleteStudent(Long studentId);

}
