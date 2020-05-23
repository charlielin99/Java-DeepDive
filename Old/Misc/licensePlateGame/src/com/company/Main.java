package com.company;

/*
O(V+E) || O(n+m) BFS
 License Plate Game
1 pt for every border crossed from the state you are in to the state on the plate
Scored individually

Ex: Driving in California
Player   | Plates Seen | Points for Plate | Total Points
---------+-------------+------------------+-------------
Player 1 | California  | 0                | 4
         | Nevada      | 1                |
         | Colorado    | 3                |
---------+-------------+------------------+-------------
Player 2 | Nevada      | 1                | 4
         | Utah        | 2                |
         | Arizona     | 1                |
---------+-------------+------------------+-------------
Player 3 | California  | 0                | 2
         | New Mexico  | 2                |

   State    |    Neighbors
------------+----------------------------------------
California  | Arizona, Nevada
Nevada      | Arizona, California, Utah
Arizona     | California, New Mexico, Nevada, Utah
Utah        | Arizona, Colorado, Nevada
New Mexico  | Arizona, Colorado
Colorado    | New Mexico, Utah
------------+----------------------------------------
 */

import java.util.*;

public class Main {

    private static class PlateDistancePair {
        public String state;
        public int distance;

        public PlateDistancePair(String state, int distance){
            this.state = state;
            this.distance = distance;
        }
    }

    public static Map<String, Integer> plateGame (Map<String, List<String>> graph, Map<String, List<String>> players){
        Map<String, Integer> ret = new HashMap<>();

        for (String s: players.keySet()){
            int points = 0;
            for (String x: players.get(s)){
                points += getDistance (graph, "California", x);
            }
            ret.put(s, points);
        }

        return ret;
    }

    public static int getDistance (Map<String, List<String>> graph, String start, String end) {

        if (!graph.containsKey(start)) {
            throw new IllegalArgumentException("Invalid Start");
        }

        if (!graph.containsKey(end)) {
            throw new IllegalArgumentException("Invalid End");
        }

        if (start.equals(end)) {
            return 0;
        }

        Queue<PlateDistancePair> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.add(new PlateDistancePair(start, 0));
        seen.add(start);

        while (!queue.isEmpty()) {
            PlateDistancePair current = queue.remove();

            for (String neighbour : graph.get(current.state)) {

                if (seen.contains(neighbour)) {
                    continue;
                }

                if (neighbour.equals(end)) {
                    return current.distance + 1;
                }

                queue.add(new PlateDistancePair(neighbour, current.distance + 1));
                seen.add(neighbour);
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        Map<String, List<String>> input = new HashMap<>();
        input.put("Player1", Arrays.asList("California", "Nevada", "Colorado"));
        input.put("Player2", Arrays.asList("Nevada", "Utah","Arizona"));
        input.put("Player3", Arrays.asList("California", "New Mexico"));


        Map<String, List<String>> graph = new HashMap<>();
        graph.put("California", Arrays.asList("Arizona", "Nevada"));
        graph.put("Nevada", Arrays.asList("Arizona", "California", "Utah"));
        graph.put("Arizona", Arrays.asList("California", "New Mexico", "Nevada", "Utah"));
        graph.put("Utah", Arrays.asList("Arizona", "Colorado", "Nevada"));
        graph.put("New Mexico", Arrays.asList("Arizona", "Colorado"));
        graph.put("Colorado", Arrays.asList("New Mexico", "Utah"));

        System.out.println(plateGame(graph,input));
    }
}