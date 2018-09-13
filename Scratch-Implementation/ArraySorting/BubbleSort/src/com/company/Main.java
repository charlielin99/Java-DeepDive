package com.company;

public class Main {

    public static void main(String[] args) {

        int [] myArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = myArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i =0; i < lastUnsortedIndex; i++){
                if (myArray[i] > myArray[i+1]){
                    swap(myArray, i, i+1);
                }
            }
        }


        for (int i=0; i<myArray.length;i++){
            System.out.println(myArray[i]);
        }

    }


    public static void swap (int[] myArray, int i, int j){
        if (i == j){
            return;
        }

        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;
    }
}
