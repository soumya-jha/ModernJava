package com.udemy.java8.functionalInterface;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<Student> c1 = (student) -> System.out.print(student.getName() + " ");
        Consumer<Student> c2 = (student) -> System.out.println(student.getActivities());
        Consumer<Student> c3 = (student) -> {
            if (student.getGradeLevel() >= 3)
                c1.andThen(c2).accept(student);
        };
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.stream().forEach(c1.andThen(c2));
        /*OR*/
        System.out.println("Students Above grade level 3");
        studentList.stream().forEach(c3);

        studentList.stream()
                .filter(student -> student.getGradeLevel()>=3)
                .forEach(student -> {
                    System.out.println("print");
                });
    }
}
