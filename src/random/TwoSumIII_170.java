package random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by sergei.kostin on 4/4/18.
 */
public class TwoSumIII_170 {

    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIII_170() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int count = map.containsKey(number) ? map.get(number) : 0;
        map.put(number, count + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int current = entry.getKey();
            int diff = value - current;
            if(diff == current){
                if(entry.getValue() > 1) return true;
            }else if(map.containsKey(diff)){
                return true;
            }
        }
        return false;
    }
}
