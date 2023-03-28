package com.udemy.java8.functionalInterface;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9;

    static Consumer<Student> c1 = (student) -> {
        if (p1.and(p2).test(student)) {
            System.out.println(student.getName() + ":" + student.getActivities());
        }
    };

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.stream().forEach(c1);
    }
}
