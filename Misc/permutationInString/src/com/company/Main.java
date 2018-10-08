package com.company;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(isContained("abcd", "debcda"));
    }

    public static boolean isContained(String a, String b) {
        if (a != null && b != null) {
            int lengthA = a.length();
            if (lengthA > b.length()) {
                return false;
            } else {
                Map<Character, Integer> map = new HashMap();

                int numSeenChar;
                for(numSeenChar = 0; numSeenChar < lengthA; ++numSeenChar) {
                    char c = a.charAt(numSeenChar);
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    } else {
                        map.replace(c, (Integer)map.get(c) + 1);
                    }
                }

                numSeenChar = 0;
                int prevBegin = 0;

                for(int i = 0; i < b.length(); ++i) {
                    char c = b.charAt(i);
                    if (map.containsKey(c)) {
                        map.replace(c, (Integer)map.get(c) - 1);
                        if ((Integer)map.get(c) < 1) {
                            map.remove(c);
                        }

                        ++numSeenChar;
                        if (numSeenChar >= lengthA - 1 && map.isEmpty()) {
                            return true;
                        }
                    } else {
                        for(int j = i - 1; j >= prevBegin; --j) {
                            char addBack = b.charAt(j);
                            if (map.containsKey(addBack)) {
                                map.replace(addBack, (Integer)map.get(addBack) + 1);
                            } else {
                                map.put(addBack, 1);
                            }
                        }

                        numSeenChar = 0;
                        prevBegin = i;
                    }
                }

                return false;
            }
        } else {
            return false;
        }
    }
}
