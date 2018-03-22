package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
  */
class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int index, TrieNode cur){
        if(cur.isWord) return true;
        for(int i = index; i < word.length; i++){
            char c = word[i];
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            } else if (c == '.'){
                return search(word, index+1, cur);
            } else {
                return false;
            }
        }
        return cur.isWord;
    }

    private static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("bab");
        dict.addWord("babs");
        dict.addWord("bcd");
        System.out.println(dict.search(".ad"));
    }

}
