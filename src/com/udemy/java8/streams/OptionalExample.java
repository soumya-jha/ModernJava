package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.getAllStudents().get(0));
        studentOptional.ifPresent(student -> System.out.println(student));

        String name = studentOptional.filter(student -> student.getGpa()>=4.2)
                .map(Student::getName).orElse("otherName");
        System.out.println(name);
    }
}
