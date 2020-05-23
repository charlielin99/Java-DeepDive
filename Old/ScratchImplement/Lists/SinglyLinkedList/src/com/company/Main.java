package com.company;


public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.getSize());


        list.addToFront(janeJones);
        list.addToFront(johndoe);
        list.addToFront(marysmith);
        list.addToFront(mikewilson);

        list.removeFromFront();

        list.printList();




    }
}
