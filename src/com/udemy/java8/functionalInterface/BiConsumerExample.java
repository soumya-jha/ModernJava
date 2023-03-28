package com.udemy.java8.functionalInterface;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplication is : " + a * b);
        };
        BiConsumer<Integer, Integer> divide = (a, b) -> {
            System.out.println("Division is : " + a / b);
        };

        multiply.andThen(divide).accept(10, 5);
    }
}
