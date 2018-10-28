package com.company;

import java.util.ArrayList;
import java.util.HashSet;

// boggle backtracking q on coderust

public class Main{

    // time : Exponential, O(N^n)
    // space: o(n^2)

    private static class IntPair{
        int first;
        int second;

        public IntPair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    private static class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    public static class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null){
                    ws.children[c - 'a'] = new TrieNode();
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean contains(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean prefix(String prefix) {
            TrieNode ws = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }

    private static class Boggle {
        // code assumes that both dimensions of grid are same
        char[][] grid;
        Trie dictionary;
        boolean[][] state;

        Boggle(char[][] g, Trie d){
            grid = g;
            dictionary = d;
            state = new boolean[g.length][g.length];
            for (int i = 0; i < g.length; ++i) {
                for (int j = 0; j < g.length; ++j) {
                    state[i][j] = false;
                }
            }
        }

        private ArrayList<IntPair> find_all_nbrs(int x, int y) {

            ArrayList<IntPair> nbrs = new ArrayList<IntPair>();
            int start_x = Math.max(0, x - 1);
            int start_y = Math.max(0, y - 1);
            int end_x = Math.min(grid.length - 1, x + 1);
            int end_y = Math.min(grid.length - 1, y + 1);

            for (int i = start_x; i <= end_x; ++i) {
                for (int j = start_y; j <= end_y; ++j) {
                    if (state[i][j]) {
                        continue;
                    }
                    nbrs.add(new IntPair(i, j));
                }
            }
            return nbrs;
        }

        void find_words_rec(int i, int j, StringBuilder current, HashSet<String> words) {

            if (current.length() > 0 && dictionary.contains(current.toString())) {
                words.add(current.toString());
            }

            // we can really speed up our algorithm if
            // we have prefix method available
            // for our dictionary by using code like below

            if (!dictionary.prefix(current.toString())) {
                // if current word is not prefix of any word in dictionary
                // we don't need to continue with search
                return;
            }


            ArrayList<IntPair> nbrs = find_all_nbrs(i, j);
            for (IntPair pr : nbrs) {
                current.append(grid[pr.first][pr.second]);
                state[pr.first][pr.second] = true;
                find_words_rec(pr.first, pr.second, current, words);
                current.setLength(current.length() - 1);
                state[pr.first][pr.second] = false;
            }
        }

        public HashSet<String> find_all_words(){
            HashSet<String> words = new HashSet<String>();
            StringBuilder current_word = new StringBuilder();
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid.length; ++j) {
                    find_words_rec(i, j, current_word, words);
                }
            }

            return words;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        Trie dictionary = new Trie();
        dictionary.insert("art");
        dictionary.insert("cat");
        dictionary.insert("cater");
        dictionary.insert("cartoon");
        dictionary.insert("eat");
        dictionary.insert("toon");
        dictionary.insert("moon");
        dictionary.insert("not");
        dictionary.insert("apple");
        dictionary.insert("ton");

        Boggle b = new Boggle(grid, dictionary);
        HashSet<String> words = b.find_all_words();
        for (String s: words) {
            System.out.println(s);
        }
    }
}
