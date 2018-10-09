/*All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.

The graph must be Hamiltonian since we know that a Hamiltonian path exists.

Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Hamiltonian path in the graph which is a valid reconstruction.

Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.

Take in as an edge list

Time complexity should be O(n + nlogn + n) (build graph O(n + nlogn), Hierholzer O(n))
Space complexity should be O(n), where n is the total number of tickets.
*/

public class Solution {

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}