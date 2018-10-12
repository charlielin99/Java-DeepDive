package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Main {

    // Given an array of integers, return all possible subsets of length k.

    /*Recursion is your friend for this task.

    For each element - "guess" if it is in the current subset, and recursively invoke with the guess and a smaller superset you can select from. Doing so for both the "yes" and "no" guesses - will result in all possible subsets.
    Restraining yourself to a certain length can be easily done in a stop clause.

    This answer is aimed for "sets" (unordered). Basically, you will need to keep track of the
    elements you have used (to not allow multiple usages) - and in the "guess" step, you have more
    than "use" and "don't use" options, you need to iterate over all unused values.

    exponential time
    o(2^n) is just regular subsets 
    */

    public static void main(String[] args) {
        List<Integer> superSet = new ArrayList<>();
        superSet.add(1);
        superSet.add(2);
        superSet.add(3);
        superSet.add(4);
        System.out.println(getSubsets(superSet,2));
    }


    private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current, List<Set<Integer>> solution) {
        //successful stop clause
        if (current.size() == k) {
            solution.add(new HashSet<>(current));
            return;
        }
        //unseccessful stop clause
        if (idx == superSet.size()) return;
        Integer x = superSet.get(idx);
        current.add(x);
        //"guess" x is in the subset
        getSubsets(superSet, k, idx+1, current, solution);
        current.remove(x);
        //"guess" x is not in the subset
        getSubsets(superSet, k, idx+1, current, solution);
    }

    public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
        return res;
    }
}
