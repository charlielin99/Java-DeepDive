class Solution {
/*
The logic I have used is to construct a Map of maps, that contains all possible a/b and b/a from the given input and their values.

For the given input
equations = [ ["a", "b"], ["b", "c"] ]. values = [2.0, 3.0]

The map that gets constructed is :

[a: [b:2.0]
b: [a:0.5], [c:3.0]
c: [b:0.333]]

For each key in the outer map, the value represents a map, that denotes all possible denominators for the key and the corresponding key/value.

With this map constructed, the logic for evaluating a query is simple in a dfs style:

To find any m/n, if the map of m contains x1, x2, x3
then
m/n = m/x1 * x1/n if this gives a valid result or m/x2 * x2/n or m/x3 * x3/n
*/
    // Time: O(n) per query, where n = number of variables. 
    // Space complexity is also O(n) since maximum depth of DFS is n.
public static double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        Map<String, Map<String, Double>> numMap = new HashMap<>();
        int i = 0;
        for(String[] str : equations) {
            insertPairs(numMap, str[0], str[1], values[i]);
            insertPairs(numMap, str[1], str[0], 1.0/values[i]);
            i++;
        }

        double[] res = new double[query.length];
        i = 0;
        for(String[] q: query) {
            Double resObj = handleQuery(q[0], q[1], numMap, new HashSet<>());
            res[i++] = (resObj != null) ? resObj : -1.0;
        }
        return res;
    }

    public static void insertPairs(Map<String, Map<String, Double>> numMap, String num, String denom, Double value) {
        Map<String, Double> denomMap = numMap.get(num);
        if(denomMap == null) {
            denomMap = new HashMap<>();
            numMap.put(num, denomMap);
        }
        denomMap.put(denom, value);
    }

    public static Double handleQuery(String num, String denom, Map<String, Map<String, Double>> numMap, Set<String> visitedSet) {
        String dupeKey = num+":"+denom;
        if(visitedSet.contains(dupeKey)) return null;
        if(!numMap.containsKey(num) || !numMap.containsKey(denom)) return null;
        if(num.equals(denom)) return 1.0;

        Map<String, Double> denomMap = numMap.get(num);
        visitedSet.add(dupeKey);
        for(String key : denomMap.keySet()) {
            Double res = handleQuery(key, denom, numMap, visitedSet);
            if(res != null) {
                return denomMap.get(key) * res;
            }
        }
        visitedSet.remove(dupeKey);
        return null;
    }
}