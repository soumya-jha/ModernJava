package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupingByAndPartitioningBy {
    public static void main(String[] args) {
        //GroupingByAndPartitioningBy.groupingBy_1();
        //GroupingByAndPartitioningBy.groupingBy_2();
        GroupingByAndPartitioningBy.partitioningBy_1();
        //GroupingByAndPartitioningBy.partitioningBy_2();
    }

    public static void groupingBy_1(){
        List<Student> studentList = StudentDataBase.getAllStudents();
       Map<String, List<Student>> studentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);
        System.out.println(studentMap.get("female"));
    }

    public static void groupingBy_2(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        Map<String, Map<String, List<Student>>> studentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.groupingBy(student -> student.getGpa()>=3.9 ?"GOOD":"AVERAGE")));
        System.out.println(studentMap);
        System.out.println(studentMap.get("female").get("GOOD"));
    }

    public static void partitioningBy_1(){
        Map<Boolean, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa()>=3.9));
        System.out.println(studentMap);
        System.out.println(studentMap.get(true));
    }

    public static void partitioningBy_2(){
        Map<Boolean, Set<Student>>  studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa()>=3.9,Collectors.toSet()));
        System.out.println(studentMap);
        System.out.println(studentMap.get(true));
        Set<Student> studentSet = studentMap.get(true);
        System.out.println(

        );
        Iterator<Student> iterator = studentSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
