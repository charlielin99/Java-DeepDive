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


        // justfiyText starts here

        List<String> ret = new ArrayList<String>();

        // 2 pointers
        int listStartIndex = 0;
        int listEndIndex;


        do {
            listEndIndex = listStartIndex;
            int remainingIndex = k;
            int timesAppended = 0;
            for (int i=listStartIndex; i < dict.size() && remainingIndex >= dict.get(i).length(); i++){
                timesAppended++;
                remainingIndex -= dict.get(i).length();
                remainingIndex --; //account for space between words
            }

            remainingIndex++; //after last word there should not be a space

            listEndIndex += timesAppended - 1; // set end pointer for this iteration of stringbuilder

            StringBuilder sBuilder = new StringBuilder();

            if (remainingIndex != 0){ // need to add additional spacing
                int spaces = (remainingIndex / (timesAppended-1)) + 1; // +1 because all words need at least one space
                int spaceOffsetCount = remainingIndex % (timesAppended-1); // how many words have additional spacing
                for (int i=listStartIndex; i<listEndIndex; i++){
                    sBuilder.append(dict.get(i));
                    if (spaceOffsetCount > 0){ // while the spaceOffsetCount is still more than 1, add an additional space
                        helper(sBuilder, spaces+1); // + 1 is that additional space because of spaceOffsetCount
                        spaceOffsetCount--;
                    } else {
                        helper(sBuilder, spaces);
                    }
                }
                //last word append out of loop because there should not be space after it
                sBuilder.append(dict.get(listEndIndex));
            } else { // regular spacing
                sBuilder.append(dict.get(listStartIndex));
                for (int i=1; i<=listEndIndex-listStartIndex; i++){
                    sBuilder.append(' ');
                    sBuilder.append(dict.get(i));
                }
            }

            ret.add(sBuilder.toString());
            listStartIndex = listEndIndex + 1;
        } while (listEndIndex != dict.size()-1);

        return ret;
    }

    public static void helper (StringBuilder sBuilder, int spaces){
        for (int i=0; i<spaces; i++){
            sBuilder.append(' ');
        }
    }









    public static List<String> justifyText2(List<String> dict, int k) {
        List<String> ret = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int currCharLeft = k;

        for (String currWord : dict) {
            currCharLeft -= currWord.length();
            if (!temp.isEmpty()) currCharLeft--;
            temp.add(currWord);
            if (currWord.length() >= currCharLeft) {
                ret.add(tempListToString(temp, k));
                temp = new ArrayList<>();
                currCharLeft = k;
            }
        }
        if (!temp.isEmpty()) {
            ret.add(tempListToString(temp, k));
        }

        return ret;
    }

    private static String tempListToString(List<String> stringList, int k) {
        StringBuilder builder = new StringBuilder();

        int spaceLength = k;
        for (String word : stringList) spaceLength -= word.length();

        if (stringList.size() == 0){
            return "";
        } else if (stringList.size() == 1) {
            builder.append(stringList.get(0));
            for(int i = 0; i < spaceLength; i++) {
                builder.append('^');
            }
        } else {
            int betweenLength = spaceLength / (stringList.size() - 1);
            int wordsWithExtraSpaces = spaceLength % (stringList.size() - 1);
            builder.append(stringList.get(0));
            for (int j = 1; j <= wordsWithExtraSpaces; j++) {
                for(int i = 0; i < betweenLength + 1; i++) {
                    builder.append('^');
                }
                builder.append(stringList.get(j));
            }
            for (int j = wordsWithExtraSpaces + 1; j < stringList.size(); j++) {
                for(int i = 0; i < betweenLength; i++) {
                    builder.append('^');
                }
                builder.append(stringList.get(j));
            }
        }

        return builder.toString();
    }
}
