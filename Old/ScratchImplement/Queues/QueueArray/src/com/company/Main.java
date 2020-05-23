package com.company;

public class Main {

    public static void main(String[] args) {


        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        ArrayQueue queue = new ArrayQueue(10);

        queue.add(janeJones);
        queue.add(johndoe);
        queue.add(marysmith);
        queue.add(mikewilson);



        queue.peak();

        queue.remove();

        queue.printQueue();
    }
}
