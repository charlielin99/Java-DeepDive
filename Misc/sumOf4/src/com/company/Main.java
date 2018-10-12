package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 7;

        System.out.println(isFourSum(arr, 6));

    }

    static class Pair {
        private int start;
        private int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }

        int getEnd() {
            return this.end;
        }

        boolean checkEqual(Pair other) {
            return this.start == other.start || this.end == other.end || this.end == other.start || this.start == other.end;
        }
    }

    /*
    both time and space should be O(n^2)
    basically you have a hashset of all combinations of twosums
    and you run the combination again and see if you can get a foursum match,
    but you gotta make sure that there are no elements counted twice

    there's that checkEqual method in the Pair class that returns true if any index is duplicated,
    in which case we throw away the result

    you are throwing in any combination of two element so space o(n^2)
    */

    public static boolean isFourSum(int[] arr, int target) {
        HashMap<Integer, HashSet<Pair>> map = new HashMap<Integer, HashSet<Pair>>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(target - sum)) {
                    HashSet<Pair> possibilities = map.get(target - sum);
                    for (Pair poss : possibilities) {
                        if (!poss.checkEqual(new Pair(i, j))) {
                            //System.out.println(poss.start + " " + poss.end + " " + i + " " + j + ", " + arr[poss.start] + " " + arr[poss.end] + " " + arr[i] + " " + arr[j]);
                            return true;
                        }
                    }
                } else {
                    map.put(target - sum, new HashSet<Pair>());
                }
                map.get(target - sum).add(new Pair(i, j));
            }
        }

        return false;
    }

}