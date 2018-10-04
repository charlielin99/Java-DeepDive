class Solution {
    
    /*
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
    */
     
    /*
    Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps; another set wordDict that has not been reached. In the while loop, for each word in the reached set, I give all variations and check if it matches anything from wordDict, if it has a match, I add that word into toAdd set, which will be my "reached" set in the next loop, and remove the word from wordDict because I already reached it in this step. And at the end of while loop, I check the size of toAdd, which means that if I can't reach any new String from wordDict, I won't be able to reach the endWord, then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".

The idea is that reached always contain only the ones we just reached in the last step, and wordDict always contain the ones that haven't been reached. This is pretty much what Dijkstra's algorithm does, or you can see this as some variation of BFS.
    */
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int step = 1;
    while (!q.isEmpty()) {
        int size = q.size();
        for (int j = 0; j < size; j++) {
            String cur = q.poll();
            for (int i = 0; i < endWord.length(); i++) {
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    StringBuilder newWord = new StringBuilder(cur);
                    newWord.setCharAt(i, letter);
                    if (set.contains(newWord.toString())) {
                        if (newWord.toString().equals(endWord)) return step + 1;
                        set.remove(newWord.toString());
                        q.offer(newWord.toString());
                    }
                }
            }
            
        }
        step++;
    }
    return 0;
}
}