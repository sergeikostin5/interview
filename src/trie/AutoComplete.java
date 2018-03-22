package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sergei.kostin on 3/1/18.
 */
public class AutoComplete {

    public List<String> getWords(String prefix, TrieNode trie){
        List<String> result = new ArrayList<>();
        for(int i=0; i < prefix.length(); i++){
            if(trie.children.containsKey(prefix.charAt(i))){
                trie = trie.children.get(prefix.charAt(i));
            }else{
                return result;
            }
        }
        getWords(trie, result);
        return result;
    }

    private void getWords(TrieNode trie, List<String> result){
        if(trie.isWord) {
            result.add(trie.prefix);
        }
        if(trie.children.isEmpty()){
            return;
        }
        for(Character c : trie.children.keySet()){
            getWords(trie.children.get(c), result);
        }
    }

    private static class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        String prefix;
        boolean isWord;

        TrieNode(String prefix){
            this.prefix = prefix;
        }
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode("");
        for(String word : words){
            TrieNode current = root;
            StringBuilder builder = new StringBuilder();
            for(char c : word.toCharArray()){
                builder.append(c);
                if(!current.children.containsKey(c)) current.children.put(c, new TrieNode(builder.toString()));
                current = current.children.get(c);
            }
            current.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] dictionary = {"abc", "abb", "hello", "hey","see", "adl", "abvf", "abcd"};
        AutoComplete ac = new AutoComplete();
        TrieNode trie = ac.buildTrie(dictionary);
        System.out.println(ac.getWords("nb", trie));

    }



}
