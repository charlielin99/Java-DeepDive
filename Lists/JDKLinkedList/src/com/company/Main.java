package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        LinkedList<Employee> list = new LinkedList<>();

        //add to FRONT of linkedlist
        list.addFirst(janeJones);
        list.addFirst(johndoe);
        list.addFirst(marysmith);

        /*
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }*/


        //adds to END of list
        list.add(mikewilson);

        //removes first item
        list.removeFirst();

        //removes from end
        list.removeLast();



        //printing
        for (Employee employee:list){
            System.out.println(employee);
        }





    }
}
