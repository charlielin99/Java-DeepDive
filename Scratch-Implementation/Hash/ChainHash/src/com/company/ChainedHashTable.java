package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashTable(){
        hashtable = new LinkedList[10];
        for (int i=0; i<hashtable.length; i++){
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                break;
            }
        }

        if (employee == null){
            return null;
        } else {
            hashtable[hashedKey].remove(employee);
            return employee.employee;
        }
    }

    public void printHashTable(){
        for (int i=0; i<hashtable.length; i++){
            if (hashtable[i].isEmpty()){
                System.out.println("Position is empty at "+ i);
            } else{
                System.out.println("Position " + i + " ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next().employee);
                    System.out.println("-->");
                }
                System.out.println("NULL");
            }
        }
    }



    public int hashKey (String key){
        return key.length() % hashtable.length;
    }

}
