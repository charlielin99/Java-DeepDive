package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johndoe);

        //Iterator<Employee> iterator = hashMap.values().iterator();
        //while (iterator.hasNext()){
        //    System.out.println(iterator.next());
        //}

        System.out.println(hashMap.containsKey("Doe"));


    }
}
