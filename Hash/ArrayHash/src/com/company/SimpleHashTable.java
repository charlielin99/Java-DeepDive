package com.company;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    public SimpleHashTable(){
        hashtable = new StoredEmployee[10];
    }

    // super simple hash based off length of string
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }


    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)){
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length-1){
                hashedKey =0;
            } else{
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // if everything fails because array full then will hit here
        if (occupied(hashedKey)){
            System.out.println("Sorry already filled " + hashedKey);
        } else{
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }

        return hashtable[hashedKey].employee;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if(hashtable[hashedKey]!= null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        } else{
            return -1;
        }
    }

    public void printHashTable(){
        for (int i=0;i<hashtable.length;i++){
            if (hashtable[i] == null){
                System.out.println("Empty");
            } else {
                System.out.println(hashtable[i].employee);
            }
        }
    }

    private boolean occupied (int index){
        return hashtable[index] != null;
    }



    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[oldHashTable.length];

        for (int i=0;i<oldHashTable.length;i++){
            if (oldHashTable[i] != null){
                put(oldHashTable[i].key, oldHashTable[i].employee);
            }
        }

        return employee;
    }

}
