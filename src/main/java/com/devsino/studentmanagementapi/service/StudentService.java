package com.devsino.studentmanagementapi.service;
import com.devsino.studentmanagementapi.model.Student;
import com.devsino.studentmanagementapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ - All students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ - One student
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Student updateStudent(Long id, Student studentDetails) {

        Student student = getStudentById(id);

        if (student == null) {
            return null;
        }

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        return studentRepository.save(student);
    }

    // DELETE
    public boolean deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }
}
