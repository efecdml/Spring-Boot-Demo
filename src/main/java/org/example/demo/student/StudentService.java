package org.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> studentModelOptional = studentRepository.findStudentByEmail(studentModel.getEmail());

        if (studentModelOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        System.out.println(studentModel);
        studentRepository.save(studentModel);
    }
}
