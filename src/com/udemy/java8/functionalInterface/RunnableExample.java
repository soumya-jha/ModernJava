package com.udemy.java8.functionalInterface;

public class RunnableExample {
    public static void main(String[] args) {

        /*Using Legacy implementation*/
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Legacy Runnable implementation");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        /*Using Java8 Lambda for functional interfaces*/

        Runnable lambdaRunnable = () -> System.out.println("Runnable with Lambda");
        new Thread(lambdaRunnable).start();
        /*OR*/
        new Thread(() -> System.out.println("Runnable with Lambda")).start();
    }
}
