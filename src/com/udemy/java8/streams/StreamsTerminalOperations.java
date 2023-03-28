package com.udemy.java8.streams;

import com.udemy.java8.db.StudentDataBase;
import com.udemy.java8.model.Student;

import java.util.*;
import java.util.stream.Collectors;

/*joining()
* counting()
* mapping()
* minBy(), maxBy() using collect
* sum(), avg() using collect
**/
public class StreamsTerminalOperations {
    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Joining1 :  " + StreamsTerminalOperations.performJoining1(studentList));
        System.out.println("Joining2 :  " + StreamsTerminalOperations.performJoining2(studentList));
        System.out.println("Joining3 :  " + StreamsTerminalOperations.performJoining3(studentList));
        System.out.println("Counting :  " + StreamsTerminalOperations.performCounting(studentList));
        System.out.println("Mapping :  " + StreamsTerminalOperations.performMapping(studentList));
        System.out.println("MaxBy :  " + StreamsTerminalOperations.performMaxBy(studentList));
        System.out.println("Sum :  " + StreamsTerminalOperations.performSum(studentList));
        System.out.println("Average :  " + StreamsTerminalOperations.performAverage(studentList));
    }

    public static String performJoining1(List<Student> studentList){
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }
    public static String performJoining2(List<Student> studentList){
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(" "));
    }
    public static String performJoining3(List<Student> studentList){
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(" ", "(**", "**)"));
    }
    public static Long performCounting(List<Student> studentList){
        return studentList.stream()
               .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }

    public static Set<String> performMapping(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
    }
    public static Optional<Student> performMaxBy(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getNoOfNotebooks)));
    }
    public static Integer performSum(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.summingInt(Student::getNoOfNotebooks));
    }
    public static Double performAverage(List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.averagingInt(Student::getNoOfNotebooks));
    }
}
