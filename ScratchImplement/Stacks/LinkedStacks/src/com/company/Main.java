package com.company;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        LinkedStack stack = new LinkedStack();

        stack.push(janeJones);
        stack.push(johndoe);
        stack.push(marysmith);
        stack.push(mikewilson);

        System.out.println(stack.peek());
        stack.pop();
        stack.push(mikewilson);

        stack.printStack();

    }
}
