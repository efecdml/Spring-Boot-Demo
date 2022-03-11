package org.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            StudentModel olga = new StudentModel("Olga",
                    "olga@mail.com",
                    LocalDate.of(2001, Month.APRIL, 11),
                    21);

            StudentModel igor = new StudentModel("Igor",
                    "igor@mail.com",
                    LocalDate.of(2002, Month.SEPTEMBER, 12),
                    21);

            studentRepository.saveAll(List.of(olga, igor));
        };
    }
}
