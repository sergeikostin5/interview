package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 3/1/18.
 */
public class BoggleSolver {

    public static void main(String[] args) {
        String[] dictionary = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        char[][] boggle = {
                {'a','b'},
                {'c','d'}
        };

        BoggleSolver bs = new BoggleSolver();
        List<String> result = bs.findWords(boggle, dictionary);
        for(String elem : result) System.out.println(elem);
    }

    private static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode current = root;
            for(Character c : word.toCharArray()){
                int i = c - 'a';
                if(current.next[i] == null) current.next[i] = new TrieNode();
                current = current.next[i];
            }
            current.word = word;
        }
        return root;
    }

    private List<String> findWords(char[][] boggle, String[] dictionary) {
        TrieNode trie = buildTrie(dictionary);
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[boggle.length][boggle[0].length];
        for(int row = 0; row < boggle.length; row++){
            for(int col = 0; col < boggle[0].length; col++){
                dfs(boggle, trie, row, col, result, visited);
            }
        }
        return result;
    }

    private void dfs(char[][] boggle, TrieNode trie, int row, int col, List<String> result, boolean[][] visited) {
        if(row<0 || col<0 || row == boggle.length || col == boggle[0].length || visited[row][col]) return;
        int pos = boggle[row][col] - 'a';
        if(trie.next[pos] == null) return;
        if(trie.next[pos].word != null){
            result.add(trie.next[pos].word);
            trie.next[pos].word = null; //handle duplicates
        }
        visited[row][col] = true;
        dfs(boggle, trie.next[pos], row - 1, col, result, visited);
        dfs(boggle, trie.next[pos], row + 1, col, result, visited);
        dfs(boggle, trie.next[pos], row, col - 1, result, visited);
        dfs(boggle, trie.next[pos], row, col + 1, result, visited);
        visited[row][col] = false;
    }

}
