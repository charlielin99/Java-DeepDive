package com.company;

/*
This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs,
and a starting airport, compute the person's itinerary. If no such itinerary exists, return null.
If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL',
you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A',
you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
However, the first one is lexicographically smaller.
*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    //for (String s: findItinerary(new String[][] {{"SFO", "HKO"}, {"YYZ", "SFO"}, {"YUL", "YYZ"}, {"HKO", "ORD"}}, "YUL")){
            //System.out.println(s);
        //}

        for (String s: findItinerary(new String[][] {{"SFO", "COM"}, {"COM", "YYZ"}}, "COM")){
            System.out.println(s);
        }
    }

    /*All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.

    The graph must be Hamiltonian since we know that a Hamiltonian path exists.

    Thus, start from target, we can apply the Hierholzer's algorithm to find a Hamiltonian path in the graph which is a valid reconstruction.

    Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.

    Take in as an edge list

    Time complexity should be O(n + nlogn + n) (build graph O(n + nlogn), Hierholzer O(n))
    Space complexity should be O(n), where n is the total number of tickets.
    */

    static Map<String, PriorityQueue<String>> flights;
    static LinkedList<String> path;
    static int validChecker = 0;

    public static List<String> findItinerary(String[][] tickets, String departure) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs(departure);
        if (validChecker < tickets.length){
            return new LinkedList<String>(){{add(null);}};
        }
        return path;
    }

    public static void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()){
            validChecker++;
            dfs(arrivals.poll());
        }
        path.addFirst(departure);
    }
}
