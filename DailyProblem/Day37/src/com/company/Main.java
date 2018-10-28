package com.company;

/*
This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

	    List<HashSet<Integer>> ret = generateSubsets(list);

	    for (Set k: ret){
            System.out.println(k);
        }
    }

    // time: o(2^n)
    // space: o(2^n)

    public static List<HashSet<Integer>> generateSubsets (List<Integer> v) {

        List<HashSet<Integer>> sets = new ArrayList<>();

        int complexity = (int) Math.pow((double)2, (double)v.size());

        for (int i=0; i<complexity; i++){
            HashSet<Integer> set = new HashSet<>();
            for (int j=0; j<v.size(); j++){
                if (getBit(i, j) == 1){
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }

        return sets;
    }

    public static int getBit(int num, int bit){
        int temp = 1 << bit;
        temp = temp & num;
        if (temp == 0){
            return 0;
        }
        return 1;
    }
}
