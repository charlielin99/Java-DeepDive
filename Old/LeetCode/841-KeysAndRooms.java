class Solution {
    /*
    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N =             rooms.length.  A key rooms[i][j] = v opens the room with number v.
    */

    //Just store all the keys we got ( equals to the rooms can visit) to a set then judge whether the size==rooms.size;
    // time O(n*m), looking at all items in the 2D list

public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited=new HashSet<>();
    addKey(0, rooms,visited);
    return visited.size() == rooms.size();
}

private void addKey(int room, List<List<Integer>> rooms,Set<Integer> visited) {
    visited.add(room);
    for (int key: rooms.get(room))
        if (!visited.contains(key)) addKey(key, rooms,visited);
    return;
}
}