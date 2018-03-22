package sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 3/8/18.
 */
public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry);
        }
    }

}
