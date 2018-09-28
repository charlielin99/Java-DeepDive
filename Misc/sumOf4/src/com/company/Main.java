package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[5];
	    arr[0] = 7;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 11;
        arr[4] = 13;

        System.out.println(isFourSum(arr, 26));

        /*
        int[] arr2 = new int[2];
        arr2[0] = 1;
        arr2[1] = 2;

        System.out.println(isFourSum2(arr2, 6));
        */

    }

    static class Pair{
        private int start;
        private int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        int getStart(){
            return this.start;
        }

        int getEnd(){
            return this.end;
        }
    }

    public static boolean isFourSum(int[] arr, int target){
        HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();

        for (int i=0; i<arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(target - sum)){
                    List<Pair> possibilities = map.get(target-sum);
                    // by placing everything of list into hashset and then comparing size
                    // I can tell if there were any repeated elements
                    Set<Pair> set = new HashSet<Pair>(possibilities);
                    if (set.size() == possibilities.size()){
                        return true;
                    }
                } else {
                    map.put(target-sum, new ArrayList<Pair>());
                }
                map.get(target-sum).add(new Pair(i, j));
            }
        }

        return false;
    }

}
