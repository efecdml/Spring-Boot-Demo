package org.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with " + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        StudentModel studentModel = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with " + studentId + " doesn't exist"));

        if (name != null && name.length() > 0 && !Objects.equals(studentModel.getName(), name)) {
            studentModel.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(studentModel.getEmail(), email)) {
            Optional<StudentModel> studentModelOptional = studentRepository.findStudentByEmail(email);
            if (studentModelOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            studentModel.setEmail(email);
        }
    }
}
