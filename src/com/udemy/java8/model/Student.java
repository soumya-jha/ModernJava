package com.udemy.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    List<String> activities = new ArrayList<>();
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private Integer noOfNotebooks;

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities, Integer noOfNotebooks) {
        this.activities = activities;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.noOfNotebooks = noOfNotebooks;
    }

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public Integer getNoOfNotebooks() {
        return noOfNotebooks;
    }

    public void setNoOfNotebooks(Integer noOfNotebooks) {
        this.noOfNotebooks = noOfNotebooks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "activities=" + activities +
                ", name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", noOfNotebooks=" + noOfNotebooks +
                '}';
    }
}
