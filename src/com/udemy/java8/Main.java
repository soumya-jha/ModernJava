package com.udemy.java8;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Student> studentList = StudentDataBase.getAllStudents();
        Map<String, Double> map = studentList.stream()
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getGpa()));



        System.out.println(map);
    }
}
