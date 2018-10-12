class Solution {
/*
We need to arrange the characters in string such that each same character is K distance apart, where distance in this problems is time b/w two similar task execution.

Idea is to add them to a priority Q and sort based on the highest frequency.
And pick the task in each round of 'n' with highest frequency. As you pick the task, decrease the frequency, and put them back after the round.

Time: O(n) because we know there are only 26 type of elements so PQ logn is disregarded
Space: O(n) for structures 

Q: why does this greedy option work?
A: The goal is to use least number of intervals.

So, lets say we have AAAAA BBB CCC DD and n = 2
Independently, just execution of A, B, C and D looks like this.
A - idle - idle - A - idle - idle - A - idle - idle - A - idle - idle - A
B - idle - idle - B - idle - idle - B
C - idle - idle - C - idle - idle - C
D - idle - idle - D

As you can see, the execution actually becomes a cycle of 3 tasks. Meaning, the task execution should have 3 unique tasks in a sequence. This uniqueness is critical for this problem. The goal is, for each cycle you need make a choice among tasks in such a way that for the next cycle you still have enough unique tasks.

Why? Lets say,
To start with, you have 4 unique tasks, ABC and D. Lets say your execution is B-C-D-B-C-D, which is a valid case, BUT you used up all D. Now for the remaining execution, you have only 3 unique tasks. Then you'll pick -B-C-A-. You used up all B and C, and remaining 4 A's, which has to be executed with idle times.

But if instead of choosing D, if you had picked the A at first, by the time you finish executing all B and C, you would still have 2 unique tasks A and D, whihc further reduces idle times. So instead of B-C-D, starting with A-B-C will ensure that, by the time B and C are used up, we still have 2 tasks to reduce idle times.
Also, note that if you start with ABC instead of BCA it can further optimize to use A immediately.
*/

public int leastInterval(char[] tasks, int n) {
     Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) {
        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
    }
    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

    q.addAll(map.entrySet());

    int count = 0;
    while (!q.isEmpty()) {
        int k = n + 1;
        List<Map.Entry> tempList = new ArrayList<>();
        while (k > 0 && !q.isEmpty()) {
            Map.Entry<Character, Integer> top = q.poll(); // most frequency task
            top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
            tempList.add(top); // collect task to add back to queue
            k--;
            count++; //successfully executed task
        }

        for (Map.Entry<Character, Integer> e : tempList) {
            if (e.getValue() > 0) q.add(e); // add valid tasks 
        }

        if (q.isEmpty()) break;
        count = count + k; // if k > 0, then it means we need to be idle
    }
    return count;
}
}