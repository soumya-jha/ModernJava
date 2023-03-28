package com.udemy.java8.functionalInterface;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {

        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Using legacy comparator " + c1.compare(6, 5));

        /*Using Lambda*/
        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println("Using lambda comparator " + c2.compare(6, 5));
    }
}
