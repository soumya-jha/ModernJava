package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*
* map()
* flatMap()
* distinct()
* count()
* sort()
* filter()
*/
public class StreamOperations {
    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Converting List<Student> to List<String> using map");
        System.out.println(StreamOperations.mapToStringList(studentList));
        System.out.println();
        System.out.println("Converting List<Student> to List<String> using map with method reference");
        System.out.println(StreamOperations.mapToStringListWithMethodReference(studentList));
        System.out.println();
        System.out.println("Converting List<Student> to List<String> using flatMap");
        System.out.println(StreamOperations.testFlatMap(studentList));
        System.out.println();
        System.out.println("Get distinct student activities");
        System.out.println(StreamOperations.getDistinctActivities(studentList));
        System.out.println();
        System.out.println("Get Sorted distinct student activities");
        System.out.println(StreamOperations.getSortedDistinctActivities(studentList));
        System.out.println();
        System.out.print("Count of distinct activities :");
        System.out.println(StreamOperations.getDistinctActivitiesCount(studentList));
        System.out.println();
        System.out.println("List<Student> filtered based on gender=female and gpa>3.9");
        System.out.println(StreamOperations.filterStudents(studentList));
    }

    private static List<String> mapToStringList(List<Student> studentList){
       List<String> nameList =  studentList.stream()
                .map((student -> {
                    String studentName = student.getName();
                    return studentName;
                })).collect(Collectors.toList());
       return nameList;
    }

    private static List<String> mapToStringListWithMethodReference(List<Student> studentList){
        List<String> nameList =  studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        return nameList;
    }

    private static List<String> testFlatMap(List<Student> studentList){
        List<String> nameList =  studentList.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return nameList;
    }

    private static List<String> getDistinctActivities(List<Student> studentList){
        List<String> nameList =  studentList.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        return nameList;
    }

    private static List<String> getSortedDistinctActivities(List<Student> studentList){
        List<String> nameList =  studentList.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
              //  .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        return nameList;
    }

    private static Long getDistinctActivitiesCount(List<Student> studentList){
        Long count =  studentList.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        return count;
    }

    private static List<Student> filterStudents(List<Student> studentList){
        return studentList.stream()
                .filter(student -> student.getGender().equals("female"))
                .filter(student -> student.getGpa()>3.9)
                .collect(Collectors.toList());
    }
}
