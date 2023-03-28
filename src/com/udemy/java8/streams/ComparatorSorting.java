package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorSorting {
    public static void main(String[] args) {
        System.out.println("Sorted by Name List : ");
        System.out.println(ComparatorSorting.sortByName(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Sorted by GPA in descending order : ");
        System.out.println(ComparatorSorting.sortByHighestGPA(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Sorted by GPA in descending order and then by grade in descending order: ");
        System.out.println(ComparatorSorting.sortByHighestGPAThenHighestGrade(StudentDataBase.getAllStudents()));
    }

    private static List<Student> sortByName(List<Student> studentList){
        List<Student> sortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
        .collect(Collectors.toList());
        return sortedList;
    }

    private static List<Student> sortByHighestGPA(List<Student> studentList){
        List<Student> sortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
        return sortedList;
    }
    private static List<Student> sortByHighestGPAThenHighestGrade(List<Student> studentList){
        List<Student> sortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getGpa).thenComparing(Student::getGradeLevel).reversed())
                .collect(Collectors.toList());
        return sortedList;
    }
}
