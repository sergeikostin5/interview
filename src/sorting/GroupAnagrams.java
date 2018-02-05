package sorting;

import java.util.*;

/**
 * Created by sergei.kostin on 12/26/17.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String elem : strs){
            String key = sortChars(elem);
            if(map.containsKey(key)){
                map.get(key).add(elem);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(elem);
                map.put(key, list);
            }
        }

        return new LinkedList<>(map.values());

    }

    private String sortChars( String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> result = ga.groupAnagrams(strs);
        for(List<String> elem : result){
            System.out.println(elem);
        }
    }

}
