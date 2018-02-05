package graph;

import java.util.*;

/**
 * [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 */
public class AlienDictionary {

    private static class Graph{

        Map<Character, Set<Character>> adjMap;
        HashSet<Character> allVertexes;

        Graph(){
            adjMap = new HashMap<>();
            allVertexes = new HashSet<>();
        }

        void addVertex(Character ch){
            allVertexes.add(ch);
            if(!adjMap.containsKey(ch)){
                adjMap.put(ch, new HashSet<>());
            }
        }

        void addEdge(Character from, Character to){
            addVertex(from);
            addVertex(to);
            adjMap.get(from).add(to);
        }

    }

    public String alienOrder(String[] words) {
        Graph graph = new Graph();

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            fillGraph(graph, word1, word2);
        }
        Stack<Character> result = new Stack<>();
        Set<Character> visited = new HashSet<>();
        for(Character ch : graph.allVertexes){
            if(!visited.contains(ch)) {
                visited.add(ch);
                topoSort(ch, result, visited, graph);
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!result.isEmpty()){
            builder.append(result.pop());
        }

        return builder.toString();

    }

    private void topoSort(Character current, Stack<Character> result, Set<Character> visited, Graph graph){
        for(Character neighbor : graph.adjMap.get(current)){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                topoSort(neighbor, result, visited, graph);
            }
        }
        result.push(current);
    }

    private void fillGraph(Graph graph, String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        for(int i = 0; i< len; i++ ){
            Character char1 = word1.charAt(i);
            Character char2 = word2.charAt(i);
            if(char1 != char2){
                graph.addEdge(char1, char2);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(words));

    }
}
