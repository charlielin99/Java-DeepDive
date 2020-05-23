package com.company;

//o(n) time
//o(lgn) space for recursively cutting everything in half

public class Main {

    public static void main(String[] args) {
	    int[] a = new int[5];
	    a[0] = 4;
        a[1] = 1;
        a[2] = 9;
        a[3] = 7;
        a[4] = 8;

        int[] result = minMax(a);
        System.out.println(result[0] + " " + result[1]);

    }


    public static int[] minMax(int[] a) {
        int[] mm = new int[2];
        if (a.length >= 2) {
            mm[0] = a[0];
            mm[1] = a[1];
        }
        mm = minMax(a,0,a.length-1);
        return mm;

    }

    public static int[] minMax(int[] a, int low, int high) {
        int[] temp = new int[2];
        if (low+1 < high) {
            int mid = (low+high)/2;
            int[] temp1 = minMax(a,low,mid);
            int[] temp2 = minMax(a,mid+1,high);

            temp[0] = Math.min(temp1[0],temp2[0]);
            temp[1] = Math.max(temp1[1],temp2[1]);
            return temp;

        } else if (low <= high) {
            if (a[low] < a[high]) {
                temp[0] = a[low];
                temp[1] = a[high];
            } else {
                temp[0] = a[high];
                temp[1] = a[low];
            }
        }

        return temp;
    }
}
