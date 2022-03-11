package org.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<StudentModel> getStudents(){
        return List.of(
                new StudentModel(1L,
                        "Olga",
                        "olga@mail.com",
                        LocalDate.of(2001, Month.APRIL,11),
                        22)
        );
    }
}
