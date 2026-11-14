package com.devsino.studentmanagementapi.repository;
import com.devsino.studentmanagementapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
