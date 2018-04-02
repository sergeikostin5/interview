package graph;

import java.util.*;

/**
 * Created by sergei.kostin on 4/1/18.
 */
public class Alien_Dictionary_269 {

    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.put(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String current = words[i];
            String next = words[i+1];
            for(int j = 0; j < Math.min(current.length(), next.length()); j++){
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)) set = map.get(c1);
                    if(!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(Character c : indegree.keySet()){
            if(indegree.get(c) == 0) q.add(c);
        }

        String result = "";
        while(!q.isEmpty()){
            Character cur = q.remove();
            result += cur;
            if(map.containsKey(cur)) {
                for (Character c : map.get(cur)) {
                    indegree.put(c, indegree.get(c) - 1);
                    if(indegree.get(c) == 0) q.add(c);
                }
            }

        }

        if(result.length() != indegree.size()) return "";
        return result;

    }

    public static void main(String[] args) {
        Alien_Dictionary_269 ad = new Alien_Dictionary_269();
        String[] words = {  "wrt",
                            "wrf",
                            "er",
                            "ett",
                            "rftt"
        };
        System.out.println(ad.alienOrder(words));
    }

}
