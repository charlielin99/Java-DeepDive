package com.company;

/*
This problem was asked by Palantir.

Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 3 extra spaces distributed evenly
*/

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    List<String> dict = new ArrayList<String>();
	    dict.add("the");
        dict.add("quick");
        dict.add("brown");
        dict.add("fox");
        dict.add("jumps");
        dict.add("over");
        dict.add("the");
        dict.add("lazy");
        dict.add("dog");
        dict.add("abcdefghijklmnop");

        List<String> ret = justifyText(dict, 16);

        for (String s: ret){
            System.out.println(s);
        }
    }

    public static List<String> justifyText(List<String> dict, int k){

        if (dict.size() == 0 || dict == null){
            return new ArrayList<String>();
        }

        // validate k
        int maxWordSizeInList = 0;
        for (String s: dict){
            if (s.length() > maxWordSizeInList){
                maxWordSizeInList = s.length();
            }
        }
        if (k < maxWordSizeInList){
            return new ArrayList<String>();
        }


        List<String> ret = new ArrayList<String>();

        int listStartCounter = 0;
        int listEndCounter;


        do {
            listEndCounter = listStartCounter;
            int remainingIndex = k;
            int timesAppended = 0;
            for (int i=listStartCounter; i < dict.size() && remainingIndex >= dict.get(i).length(); i++){
                timesAppended++;
                remainingIndex -= dict.get(i).length();
                remainingIndex --; //account for space between words
            }

            remainingIndex++; //after last word there should not be a space

            listEndCounter += timesAppended - 1;

            StringBuilder sBuilder = new StringBuilder();

            if (remainingIndex != 0){ // need to add spacing
                int spaces = (remainingIndex / (timesAppended-1)) + 1;
                int spaceOffset = remainingIndex % (timesAppended-1);
                for (int i=listStartCounter; i<listEndCounter; i++){
                    sBuilder.append(dict.get(i));
                    if (spaceOffset > 0){
                        helper(sBuilder, spaces+1);
                        spaceOffset--;
                    } else {
                        helper(sBuilder, spaces);
                    }
                }
                //last word append
                sBuilder.append(dict.get(listEndCounter));
            } else {
                sBuilder.append(dict.get(listStartCounter));
                for (int i=1; i<=listEndCounter-listStartCounter; i++){
                    sBuilder.append(' ');
                    sBuilder.append(dict.get(i));
                }
            }

            ret.add(sBuilder.toString());
            listStartCounter = listEndCounter + 1;
        } while (listEndCounter != dict.size()-1);

        return ret;
    }

    public static void helper (StringBuilder sBuilder, int spaces){
        for (int i=0; i<spaces; i++){
            sBuilder.append(' ');
        }
    }
}
