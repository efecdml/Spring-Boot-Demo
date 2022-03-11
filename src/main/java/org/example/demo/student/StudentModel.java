package org.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table

public class StudentModel {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String epost;
    private LocalDate dateOfBirth;
    private int age;

    public StudentModel() {
    }

    public StudentModel(String name,
                        String epost,
                        LocalDate dateOfBirth,
                        int age) {
        this.name = name;
        this.epost = epost;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public StudentModel(Long id,
                        String name,
                        String epost,
                        LocalDate dateOfBirth,
                        int age) {
        this.id = id;
        this.name = name;
        this.epost = epost;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", epost='" + epost + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
