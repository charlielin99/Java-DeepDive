package com.company;

// 1. You are given a Bag of colored marbles 
// 2. Write a method to pick a random marble + return the color of the picked marble + remove that marble from the bag

import java.util.*;

public class Main {

    private static class EasyMarble { // O(1) time pickMarble, O(n) space
        static List<String> marbles;

        public EasyMarble(String[] input){
            marbles = new ArrayList<>(Arrays.asList(input));
        }

        public static String pickMarble (){
            int random = randInt(0, marbles.size()-1);
            String returnVal = marbles.get(random);
            Collections.swap(marbles, random, marbles.size()-1);
            marbles.remove(marbles.size()-1);
            return returnVal;
        }

        public static int randInt (int min, int max){
            Random rand = new Random();
            return rand.nextInt((max - min) + 1) + min;
        }
    }

    /*private static class HardMarble { // O(lg n) time pickMarble, O(1) space

        public HardMarble(String[] input){

        }
    }*/

    public static void main(String[] args) {
	    String[] input = new String[] {"Blue", "Green", "Blue", "Red", "Blue"};
	    EasyMarble easy = new EasyMarble(input);

        for (int i=0; i<5; i++){
            System.out.println(easy.pickMarble());
        }
    }

}
