package com.company;

public class Main {

    //counting sort based approach
    //o(n)
    //o(n)

    /*
    oh yeah so im traversing the frequency array and add stuff into my new string bc i dont want duplicates adjacents,
    and each time i put a char the string i will decrement the frequency until it's zero
    so i need to keep track of what the last element is (prev)
    if it's the same with current element it means i've exausted all other letters and
    it's not possible to make a string w not duplicate elements next to each other
    and for maxindex and maxamount
    i have to keep track of that bc i need to start with the most frequent letter
    say if i have bbbaa, my combination much start with a 'b'
    */

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
