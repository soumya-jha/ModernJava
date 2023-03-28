package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.Optional;

public class MapFilterReduceExample {
    public static void main(String[] args) {
        System.out.println(MapFilterReduceExample.getTotalNoOfNotebooks(StudentDataBase.getAllStudents()));
        //using optional
        Optional<Integer> optional = MapFilterReduceExample.getTotalNoOfNotebooks1(StudentDataBase.getAllStudents());
        if(optional.isPresent())
            System.out.println("Using optional : " + optional.get());
    }

    private static Integer getTotalNoOfNotebooks(List<Student> studentList){
        return studentList.stream()
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoOfNotebooks)
                .reduce(0, (a,b) -> a+b);
    }


    private static Optional<Integer> getTotalNoOfNotebooks1(List<Student> studentList){
        return studentList.stream()
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoOfNotebooks)
                .reduce((a,b) -> a+b);
    }
}
