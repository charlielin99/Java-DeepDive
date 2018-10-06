import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {
        if (!graph.containsKey(startNode)){
            throw new IllegalArgumentException("Start node not in graph");
        }
        
        if (!graph.containsKey(endNode)){
            throw new IllegalArgumentException("End node not in graph");
        }
        
        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);
        
        Map<String, String> howWeReachedNodes = new HashMap<>();
        howWeReachedNodes.put(startNode, null);
        
        while (!nodesToVisit.isEmpty()){
            String currentNode = nodesToVisit.remove();
            
            if (currentNode.equals(endNode)){
                return reconstructPath(howWeReachedNodes, startNode, endNode);    
            }
            
            for (String neighbor: graph.get(currentNode)){
                if (!howWeReachedNodes.containsKey(neighbor)){
                    nodesToVisit.add(neighbor);
                    howWeReachedNodes.put(neighbor, currentNode);
                }
            }
        }
        
        return null;
    }
    
    private static String[] reconstructPath(Map<String, String> previousNodes, String startNode, String endNode){
        List<String> reversedShortestPath = new ArrayList<>();
        
        String currentNode = endNode;
        
        while (currentNode != null){
            reversedShortestPath.add(currentNode);
            currentNode = previousNodes.get(currentNode);
        }
        
        Collections.reverse(reversedShortestPath);
        return reversedShortestPath.toArray(new String[reversedShortestPath.size()]);
    }


















    // tests

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
    }

    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() { {
            put("a", new String[] {"b", "c", "d"});
            put("b", new String[] {"a", "d"});
            put("c", new String[] {"a", "e"});
            put("d", new String[] {"a", "b"});
            put("e", new String[] {"c"});
            put("f", new String[] {"g"});
            put("g", new String[] {"f"});
        }};
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}