package com.example;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String answer = "";

            if (i % 3 == 0) {
                answer += "Fizz";
            }
            if (i % 5 == 0) {
                answer += "Buzz";
            }
            if (i % 7 == 0) {
                answer += "Jazz";
            }
            if (answer.isEmpty()) {
                answer = Integer.toString(i);
            }

            System.out.println(answer);
        }
    }
}