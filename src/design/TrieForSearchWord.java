package design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 3/25/18.
 */
public class TrieForSearchWord {

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), root, 0);
    }

    private boolean search(char[] word, TrieNode current, int level) {
        if(current == null) return false;
        if(level == word.length && current.isWord) return true;
        if(level == word.length && !current.isWord) return false;
        if(word[level] != '.' && !current.children.containsKey(word[level])) return false;
        if(word[level] == '.') {
            for(Character c : current.children.keySet()){
                return search(word, current.children.get(c), level + 1);
            }
        }
        return search(word, current.children.get(word[level]), level+1);

    }

    private static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {



        TrieForSearchWord tsw = new TrieForSearchWord();
        tsw.addWord("WordDictionary");
        tsw.addWord("addWord");
        tsw.addWord("addWord");
        tsw.addWord("addWord");
        tsw.addWord("addWord");
        tsw.addWord("search");
        tsw.addWord("search");
        tsw.addWord("addWord");
        tsw.addWord("search");
        tsw.addWord("search");
        tsw.addWord("search");
        tsw.addWord("search");
        tsw.addWord("search");
        tsw.addWord("search");
        System.out.println(tsw.search(""));
        System.out.println(tsw.search("at")); // -> false
        System.out.println(tsw.search("and")); // -> true
        System.out.println(tsw.search("s....h"));     // -> true
        System.out.println(tsw.search("add"));     // -> true
        System.out.println(tsw.search("a"));     // -> true
        System.out.println(tsw.search("at"));     // -> true
        System.out.println(tsw.search("bat"));     // -> true
        System.out.println(tsw.search(".at"));     // -> true
        System.out.println(tsw.search("an."));     // -> true
        System.out.println(tsw.search("a.d."));     // -> true
        System.out.println(tsw.search("b."));     // -> true
        System.out.println(tsw.search("a.d"));     // -> true
        System.out.println(tsw.search("."));     // -> true
    }

}
