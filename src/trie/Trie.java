package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class Trie {

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        TrieNode(){
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        // mark the current nodes endOfWord as true
        current.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) return false;
            current = node;
        }
        return current.isEndOfWord;
    }

    public boolean delete(String word){
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            // when end of word is reached delete if endOfWord == true
            if(!current.isEndOfWord){
                return false;
            }
            current.isEndOfWord = false;
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index+1);
        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("hell");
        System.out.println(tr.search("hello"));
    }

}
