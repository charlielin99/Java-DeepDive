package com.company;

/*
Given two strings a and b, write a function to determine if any anagrams of a are a substring of b.
*/

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(isContained("abcd", "debcda"));
    }


    public static boolean isContained(String a, String b) {

        if (a == null || b == null) {
            return false;
        }

        int lengthA = a.length();

        if (lengthA > b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < lengthA; i++) {
            char c = a.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c)+1);
            }
        }

        int numSeenChar = 0;
        int prevBegin = 0;

        for (int i=0; i<b.length(); i++) {

            char c = b.charAt(i);

            if (!map.containsKey(c)) {
                // put everything removed before back into map
                for (int j = i-1; j >= prevBegin; j--) {
                    char addBack = b.charAt(j);
                    if (map.containsKey(addBack)) {
                        map.replace(addBack, map.get(addBack) + 1);
                    } else {
                        map.put(addBack, 1);
                    }
                }
                numSeenChar = 0;
                prevBegin = i;
                continue;
            } else {
                map.replace(c, map.get(c) - 1);
                if (map.get(c) < 1) {
                    map.remove(c);
                }
                numSeenChar++;
            }

            if (numSeenChar >= lengthA - 1 && map.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
