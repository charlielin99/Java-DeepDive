package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        String string1 = string.toLowerCase();
        
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(string1.length());

        for(int i=0;i<string1.length();i++){
            char mychar = string1.charAt(i);
            if (mychar >= 'a' && mychar <= 'z'){ //checks if character is a letter a-z
                stack.push(mychar);
                stringNoPunctuation.append(mychar);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());

        while(!stack.isEmpty()){
            reversedString.append(stack.pop());
        }

        return stringNoPunctuation.toString().equals(reversedString.toString());

    }

}
