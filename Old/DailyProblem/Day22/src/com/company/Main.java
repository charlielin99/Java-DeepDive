package com.company;

/*
This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces),
return the original sentence in a list. If there is more than one possible reconstruction, return any of them.
If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox',
and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond',
and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "thequickbrownfox";
        List<String> dict = new ArrayList<String>();
        dict.add("quick");
        dict.add("brown");
        dict.add("the");
        dict.add("fox");

        String s1 = "bedbathandbeyond";
        List<String> dict1 = new ArrayList<String>();
        dict1.add("bed");
        dict1.add("bath");
        dict1.add("bedbath");
        dict1.add("and");
        dict1.add("beyond");


	    List<String> res = wordBreak(s1, dict1);
	    for (String t: res){
            System.out.println(t);
        }
    }

    public static List<String> wordBreak(String s, List<String> dict) {
        return backtrack(s,dict,new HashMap<String, List<String>>());
    }
    // backtrack returns an array including all substrings derived from s.
    public static List<String> backtrack(String s, List<String> dict, Map<String,List<String>> mem){
        if(mem.containsKey(s)) return mem.get(s);
        List<String> result = new ArrayList<String>();
        for(String word: dict)
            if(s.startsWith(word)) {
                String next = s.substring(word.length());
                if(next.length()==0) result.add(word);
                else for(String sub: backtrack(next, dict, mem)) result.add(word+" "+sub);
            }
        mem.put(s, result);
        return result;
    }
}
