/*
Use trie. Instead of using a boolean field to indicate if this node is a word, use an int to store the times the word appeared.
1. Constructor: insert sentences and times into trie.
2. Input: 
    1. If char == '#', add stored string to trie and return an empty list.
    2. Otherwise, add the char to stored string and traverse trie to get auto-complete result.

Say n is the number of sentences in the dictionary.
Constructor: O(n).
input(): say the depth of the trie is d, and every trie node has an average of c children. lookup and traverse together take O(c^d). Sorting the history takes O(nlogn). So the overall time complexity is O(c^d + nlogn).
*/

class AutocompleteSystem {
    class Entry {
        String sentence;
        int times;
        
        Entry(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        int times;
        
        TrieNode() {
            children = new TrieNode[27];
            times = 0;
        }
    }
    
    private TrieNode root;
    private TrieNode previous;
    private String query;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        query = "";
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            insert(query, 1);
            previous = null;
            query = "";
            return result;
        }
        
        query += c;
        List<Entry> history = lookup(c);
        history.sort((a, b) -> {
            if (a.times == b.times) {
                return a.sentence.compareTo(b.sentence);
            }
            return b.times - a.times;
        });
        for (int i = 0; i < Math.min(history.size(), 3); i++) {
            result.add(history.get(i).sentence);
        }
        return result;
    }
    
    private void insert(String sentence, int times) {
        TrieNode current = root;
        for (char c : sentence.toCharArray()) {
            int index = c == ' ' ? 26 : c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.times += times;
    }
    
    private List<Entry> lookup(char c) {
        List<Entry> history = new ArrayList<>();
        if (previous == null && query.length() > 1) {
            return history;
        }
        
        TrieNode current = previous == null ? root : previous;
        int index = c == ' ' ? 26 : c - 'a';
        if (current.children[index] == null) {
            previous = null;
            return history;
        }
        
        previous = current.children[index];
        traverse(query, previous, history);
        return history;
    }
    
    private void traverse(String s, TrieNode node, List<Entry> history) {
        if (node.times > 0) {
            history.add(new Entry(s, node.times));
        }
        
        for (int i = 0; i < 27; i++) {
            if (node.children[i] != null) {
                String next = i == 26 ? s + ' ' : s + (char) ('a' + i);
                traverse(next, node.children[i], history);
            }
        }
    }
}