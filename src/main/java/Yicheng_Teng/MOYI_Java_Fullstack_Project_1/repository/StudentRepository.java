package Yicheng_Teng.MOYI_Java_Fullstack_Project_1.repository;

import Yicheng_Teng.MOYI_Java_Fullstack_Project_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {
}
