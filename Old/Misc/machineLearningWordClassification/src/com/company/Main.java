package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {



    static class TrieNode{
        public TrieNode[] children = new TrieNode[27];
        public boolean isWord;
        public TrieNode() {}
    }

    public static class Trie {
        private TrieNode root;
        private Set<String> memo = new HashSet<>();
        public Trie() {
            root = new TrieNode();
        }

        public void insert (List<String> dict){
            for (String s: dict){
                List<String> subsets = generateSubsets(s);
                for (String sub: subsets){
                    if (!memo.contains(sub)){
                        insert(sub);
                        memo.add(sub);
                    }
                }
            }
        }

        public void insert (String word){
            TrieNode node = root;
            for (int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if (c == '.'){ // { == index 26
                    c = '{';
                }
                if (node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        public boolean search (String word){
            if (word.length() == 0 || word == null){
                return false;
            }

            TrieNode node = root;
            for (int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if (c == '.') { // { == index 26
                    c = '{';
                }
                if (node.children[c - 'a'] == null){
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }

        public List<String> generateSubsets(String v) {

            int complexity = (int) Math.pow((double)2, (double)v.length());
            List<String> ret = new ArrayList<>(complexity);

            for (int i=0; i<complexity; i++){
                StringBuilder sBuilder = new StringBuilder(v.length());
                for (int j=0; j<v.length(); j++){
                    if (getBit(i, j) == 1){
                        char x = v.charAt(j);
                        sBuilder.append(x);
                    } else if (getBit(i, j) == 0){
                        sBuilder.append('.');
                    }
                }
                ret.add(sBuilder.toString());
            }

            return ret;
        }

        public int getBit(int num, int bit){
            int temp = 1 << bit;
            temp = temp & num;
            if (temp == 0){
                return 0;
            }
            return 1;
        }
    }




    public static void main(String[] args) {
        Trie trie = new Trie();

        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cow");
        dict.add("dog");
        dict.add("rat");
        dict.add("turtle");

        trie.insert(dict);


        System.out.println(trie.search("c.t"));
        System.out.println(trie.search("truck"));
        System.out.println(trie.search("..."));
        System.out.println(trie.search(".."));
        System.out.println(trie.search("..g"));

    }
}

