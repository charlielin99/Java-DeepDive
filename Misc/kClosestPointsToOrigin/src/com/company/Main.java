package com.company;
import java.util.*;

public class Main {

    static class Tuple implements Comparable<Tuple> {
        public int x;
        public int y;

        public int getDistance() {
            return distance;
        }

        public int distance;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Tuple input) {
            if (this.getDistance() > input.getDistance()) {
                return 1;
            } else if (this.getDistance() < input.getDistance()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Tuple[] coordinates = new Tuple[6];
        coordinates[0] = new Tuple(-2, -4);
        coordinates[1] = new Tuple(0, -2);
        coordinates[2] = new Tuple(-1, 0);
        coordinates[3] = new Tuple(3, -5);
        coordinates[4] = new Tuple(-2, -3);
        coordinates[5] = new Tuple(3, 2);

        Tuple[] result = kthClosestPoints(coordinates, 3);

        for (Tuple tup: result){
            System.out.println(tup.x);
            System.out.println(tup.y);
            System.out.println();
        }

    }

    // THIS TECHNIQUE GETS O(K+(N-K)lgK) AS OPPOSED TO O(NlgN)

    public static Tuple[] kthClosestPoints(Tuple[] coordinates, int k){
        for (Tuple coor: coordinates){
            coor.distance = getDistance(coor);
        }


        PriorityQueue<Tuple> maxHeap = new PriorityQueue<Tuple>(k, Collections.reverseOrder());
        for (int i=0; i<k; i++){
            maxHeap.add(coordinates[i]);
        }

        for (int i=k; i<coordinates.length; i++){
            if (coordinates[i].distance < maxHeap.peek().distance){
                maxHeap.poll();
                maxHeap.add(coordinates[i]);
            }
        }

        Tuple[] output = new Tuple[maxHeap.size()];
        maxHeap.toArray(output);
        return output;
    }

    public static int getDistance(Tuple coor){
        return (int)Math.sqrt((coor.x*coor.x) + (coor.y*coor.y));
    }
}