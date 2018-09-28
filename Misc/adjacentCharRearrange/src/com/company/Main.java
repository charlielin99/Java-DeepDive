package com.company;

public class Main {

    public static String rearrange(String word) {
        char[] letters = word.toCharArray();
        int[] frequency = new int[26];
        int prev = -1, curr = 0, wordsLeft = word.length(), maxIndex = 0, maxAmount = 0;
        String ret = "";

        for (char letter: letters) {
            int index = (int)letter - 97;
            frequency[index] ++;
            if (maxAmount < frequency[index]) {
                maxIndex = index;
                maxAmount = frequency[index];
            }
        }

        curr = maxIndex;
        while(wordsLeft > 0) {
            if (frequency[curr] > 0) {
                if (curr == prev) return "Not possible";

                ret += (char)(curr + 97);
                frequency[curr] --;
                wordsLeft --;
                prev = curr;
            }
            curr++;
            if (curr > 25) curr = 0;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(rearrange("aaahelloworld"));
        System.out.println(rearrange("aaaab"));
        System.out.println(rearrange("aaabbb"));
        System.out.println(rearrange("bbbcc"));
        System.out.println(rearrange("bbbaa"));
    }
}
