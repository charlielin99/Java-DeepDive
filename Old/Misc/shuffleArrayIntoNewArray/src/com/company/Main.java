package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static int randomNum(int lower, int upper) {
        // TODO
    }

    static int[] shuffle(int[] array) {
        int temp, currRandomNum;

        int[] duplicate = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            duplicate[i] = array[i];
        }

        for (int i = 0; i < duplicate.length; i++) {
            currRandomNum = randomNum(i, duplicate.length);
            temp = duplicate[i];
            duplicate[i] = duplicate[currRandomNum];
            duplicate[currRandomNum] = temp;
        }

        return duplicate;
    }
}
