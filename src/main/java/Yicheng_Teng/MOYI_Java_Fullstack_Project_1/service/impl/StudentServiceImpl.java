package Yicheng_Teng.MOYI_Java_Fullstack_Project_1.service.impl;

import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.dto.StudentDto;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.entity.Student;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.exception.ResourceNotFoundException;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.mapper.StudentMapper;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.repository.StudentRepository;
import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }


    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudentDto) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("Student not found with id: " + studentId));

        student.setFirstName(updatedStudentDto.getFirstName());
        student.setLastName(updatedStudentDto.getLastName());
        student.setEmail(updatedStudentDto.getEmail());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }



    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + studentId));

        studentRepository.deleteById(studentId);
    }
}
