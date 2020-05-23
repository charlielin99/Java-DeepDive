/*

https://leetcode.com/articles/kill-process/


Approach #3 HashMap + Depth First Search [Accepted]

Instead of making the tree structure, we can directly make use of a data structure which stores a particular process value and the list of its direct children. For this, in the current implementation, we make use of a hashmap mapmap, which stores the data in the form {parent: [list of all its direct children]}parent:[listofallitsdirectchildren].

Thus, now, by traversing just once over the ppidppid array, and adding the corresponding pidpid values to the children list at the same time, we can obtain a better structure storing the parent-children relationship.

Again, similar to the previous approach, now we can add the process to be killed to the return list, and keep on adding its children to the return list in a recursive manner by obtaining the child information from the structure created previously.

Time complexity : O(n)O(n). We need to traverse over the ppidppid array of size nn once. The getAllChildren function also takes atmost nn time, since no node can be a child of two nodes.

Space complexity : O(n)O(n). mapmap of size nn is used.

*/


public class Solution {
    public List < Integer > killProcess(List < Integer > pid, List < Integer > ppid, int kill) {
        HashMap < Integer, List < Integer >> map = new HashMap < > ();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List < Integer > l = map.getOrDefault(ppid.get(i), new ArrayList < Integer > ());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        List < Integer > l = new ArrayList < > ();
        l.add(kill);
        getAllChildren(map, l, kill);
        return l;
    }
    public void getAllChildren(HashMap < Integer, List < Integer >> map, List < Integer > l, int kill) {
        if (map.containsKey(kill))
            for (int id: map.get(kill)) {
                l.add(id);
                getAllChildren(map, l, id);
            }
    }
}
