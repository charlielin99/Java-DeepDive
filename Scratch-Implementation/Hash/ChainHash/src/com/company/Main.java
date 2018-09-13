package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johndoe = new Employee("john", "doe", 123);
        Employee marysmith = new Employee("mary", "smith", 123);
        Employee mikewilson = new Employee("mike", "wilson", 123);

        ChainedHashTable ht = new ChainedHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johndoe);
        ht.put("Wilson", mikewilson);
        ht.put("Smith", marysmith);

        ht.remove("Smith");

        ht.printHashTable();
    }
}
