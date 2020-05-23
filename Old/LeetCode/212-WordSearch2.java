class Solution {
    //My original solution is just like what we do in the problem of word search——sort of like brute-force dfs
    // board[i][j] = '#'; is awesome! Saved O(n^2) space - "what you've already seen"
    // time n^2 * 3^word.length() ???
    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();  // map is used to avoid duplicate
        for (String word: words){
            if (!map.containsKey(word) && findWord(board, word)) {
                res.add(word);
                map.put(word, 1);
            }
        }
        return res;
    }
    
    private boolean findWord(char[][] board, String word) {
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) return true; 
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int cur, int i, int j) {
        if (cur == word.length()) return true;
        if (i < 0 ||  i >= board.length ||  j < 0 ||  j >= board[0].length) return false;
        if (word.charAt(cur) != board[i][j]) return false;
        board[i][j] = '#';
        boolean res = dfs(board, word, cur+1, i-1, j) ||
                        dfs(board, word, cur+1, i+1, j) ||
                        dfs(board, word, cur+1, i, j-1) || 
                        dfs(board, word, cur+1, i, j+1);
        board[i][j] = word.charAt(cur);
        return res;
    }
}


/*
class Solution {

Time: O(word num * word length) + O(row * col * word length) - includes buildilng the Trie
Space: O (word num * word length) from trie + O (word length) from dfs

Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

How do we instantly know the current character is invalid? HashMap?
How do we instantly know what's the next valid character? LinkedList?
But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
Combing them, Trie is the natural choice. Notice that:

TrieNode is all we need. search and startsWith are useless.
No need to store character at TrieNode. c.next[i] != null is enough.
Never use c1 + c2 + c3. Use StringBuilder.
No need to use O(n^2) extra space visited[m][n].
No need to use StringBuilder. Storing word itself at leaf node is enough.
No need to use HashSet to de-duplicate. Use "one time search" trie.

board[i][j] = '#'; is awesome! Saved O(n^2) space.

    public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}

public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}  
}

*/