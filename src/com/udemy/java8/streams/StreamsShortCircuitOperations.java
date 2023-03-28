package com.udemy.java8.streams;

/*
 * The operations which does not allow the stream to execute till the end
 * limit()
 * anyMatch()
 * allMatch()
 * noneMatch()
 * findAny()
 * findFirst()
 *
 * skip() is not a short circuit operation since it skips elements int the beginning but executes till the end.
 * */

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsShortCircuitOperations {
    public static void main(String[] args) {
        System.out.println("Result of anyMatch - True if any student matches this criteria : " +
                StreamsShortCircuitOperations.performAnyMatch(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of allMatch - True if all students matches this criteria : " +
                StreamsShortCircuitOperations.performAllMatch(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of noneMatch - True if none of the students matches this criteria : " +
                StreamsShortCircuitOperations.performNoneMatch(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of findFirst - Returns the first element from the stream that matches the filter: " +
                "In case of parallel stream also, it will always return the first match of the stream : " +
                StreamsShortCircuitOperations.performFindFirst(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of findAny - Returns the first element from the stream that matches the filter: " +
                "In case of parallel stream, it will always return the first match that it encounters in stream : " +
                StreamsShortCircuitOperations.performFindAny(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of limit : " +
                StreamsShortCircuitOperations.performLimitOperation(StudentDataBase.getAllStudents()));
        System.out.println();
        System.out.println("Result of skip : " +
                StreamsShortCircuitOperations.performSkipOperation(StudentDataBase.getAllStudents()));
    }

    public static boolean performAnyMatch(List<Student> studentList) {
        return studentList.stream()
                .anyMatch(student -> student.getGpa() >= 4.0);
    }
    public static boolean performAllMatch(List<Student> studentList) {
        return studentList.stream()
                .allMatch(student -> student.getGpa() >= 3.9);
    }

    public static boolean performNoneMatch(List<Student> studentList) {
        return studentList.stream()
                .noneMatch(student -> student.getGpa() >= 4.5);
    }

    public static Optional<Student> performFindFirst(List<Student> studentList) {
        return studentList.parallelStream()
                .filter(student -> student.getGpa()>=3.9)
                .findFirst();
    }
    public static Optional<Student> performFindAny(List<Student> studentList) {
        return studentList.parallelStream()
                .filter(student -> student.getGpa()>=3.9)
                .findAny();
    }
    public static List<String> performLimitOperation(List<Student> studentList) {
        return studentList.stream()
                .limit(4)
                .filter(student -> student.getGpa()>=3.9)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static List<String> performSkipOperation(List<Student> studentList) {
        return studentList.stream()
                .skip(3)
                .filter(student -> student.getGpa()>=3.9)
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
