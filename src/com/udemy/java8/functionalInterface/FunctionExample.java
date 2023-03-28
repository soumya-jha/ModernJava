package com.udemy.java8.functionalInterface;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    Function<List<Student>, Map<String, Double>> getStudentGradeMap = (students) -> {
        Map<String, Double> gradeMap = new HashMap<>();
        students.stream().forEach((student -> {
            if (PredicateAndConsumerExample.p1.and(PredicateAndConsumerExample.p2).test(student)) {
                gradeMap.put(student.getName(), student.getGpa());
            }
        }));
        return gradeMap;
    };

    Function<List<Student>, Map<String, Double>> getStudentGradeMap1 = (students) -> students.stream()
            .filter(PredicateAndConsumerExample.p1)
            .filter(PredicateAndConsumerExample.p2)
            .collect(Collectors.toMap(Student::getName, Student::getGpa));

    public static void main(String[] args) {
        System.out.println(new FunctionExample().getStudentGradeMap.apply(StudentDataBase.getAllStudents()));

        System.out.println(new FunctionExample().getStudentGradeMap1.apply(StudentDataBase.getAllStudents()));
    }
}
