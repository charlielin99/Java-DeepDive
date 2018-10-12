package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[] {"may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        wordsWithSameCharSet(words);
    }

    /*
    The idea is to use hashing. We generate a key for all words. 
    The key contains all unique character (Size of key is at most 26 for lower case alphabets). 
    We store indexes of words as values for a key. Once we have filled all keys and values in 
    hash table, we can print the result by traversing the table.


    Time complexity : O(n*k) where n is number of words in dictionary and k is maximum length of a word.

    */

    public static void wordsWithSameCharSet(String[] words){
       int n = words.length;

       Map<String, List<Integer>> map = new HashMap<>();

        // Traverse all words
        for (int i=0; i<n; i++) {
            String key = getKey(words[i]);

            // if the key is already in the map
            // then get its corresponding value
            // and update the list and put it in the map
            if(map.containsKey(key)) {
                List<Integer> get_al = map.get(key);
                get_al.add(i);
                map.put(key, get_al);
            }

            // if key is not present in the map
            // then create a new list and add
            // both key and the list
            else {
                List<Integer> new_al = new ArrayList<>();
                new_al.add(i);
                map.put(key, new_al);
            }
        }

        for (Map.Entry<String, List<Integer>> it : map.entrySet()) {
            List<Integer> get =it.getValue();
            for (Integer v:get)
                System.out.print( words[v] + ", ");
            System.out.println();
        }
    }


    // Generates a key from given string. The key
    // contains all unique characters of given string
    // in sorted order.
    static String getKey(String str) {

        int maxChar = 26;

        boolean[] visited = new boolean[maxChar];
        Arrays.fill(visited, false);

        // store all unique characters of current
        // word in key
        for (int j = 0; j < str.length(); j++)
            visited[str.charAt(j) - 'a'] = true;
        String key = "";
        for (int j=0; j < maxChar; j++)
            if (visited[j])
                key = key + (char)('a'+ j);
        return key;
    }

}
