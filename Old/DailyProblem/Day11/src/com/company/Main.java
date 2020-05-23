package com.company;

/*
This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        TrieNode(char c){
            //TrieNode node = new TrieNode();
            this.val = c;
        }
    }

    public static class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null){
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }

        public List<String> startsWithList(String prefix){
            TrieNode ws = root;

            for(int i=0; i<prefix.length(); i++){
                char c = prefix.charAt(i);
                if (ws.children[c-'a'] != null){
                    ws = ws.children[c - 'a'];
                }
            }

            return getElements(prefix, ws, "", new ArrayList<String>());
        }

        public List<String> getElements(String prefix, TrieNode t, String word, List<String> elems){
            if (t.isWord){
                elems.add(prefix + word);
            }

            for(int i=0; i<t.children.length; i++){
                if (t.children[i] != null){
                    char c = t.children[i].val;
                    getElements(prefix, t.children[i], word + c, elems);
                }
            }

            return elems;
        }
    }


    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("dog");
        myList.add("deer");
        myList.add("deal");

        List<String> result = autoComplete("de", myList);
        System.out.println(result);
    }

    public static List<String> autoComplete (String query, List<String> dictionary){

        Trie trie = new Trie();

        for (String dict: dictionary){
            trie.insert(dict);
        }

        return trie.startsWithList(query);
    }
}
