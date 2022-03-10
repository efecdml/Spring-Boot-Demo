package org.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping
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
