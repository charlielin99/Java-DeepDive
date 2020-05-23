package com.company;

public class Main {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("jane", "jones", 123));
        stack.push(new Employee("john", "doe", 4567));

        stack.printStack();

    }
}
