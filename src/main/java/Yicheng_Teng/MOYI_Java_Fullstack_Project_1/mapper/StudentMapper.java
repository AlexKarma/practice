package Yicheng_Teng.MOYI_Java_Fullstack_Project_1.mapper;

import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.dto.StudentDto;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

    }
    public static Student mapToStudent(StudentDto studentDto){

        return new Student(
              studentDto.getId(),
              studentDto.getFirstName(),
              studentDto.getLastName(),
              studentDto.getEmail()
        );
    }
}