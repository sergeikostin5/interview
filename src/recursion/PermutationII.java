package recursion;

import java.util.*;

/**
 * Created by sergei.kostin on 2/9/18.
 */
public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        int[] values = new int[map.size()];
        int[] sizes = new int[map.size()];

        int i = 0;
        for(Integer elem : map.keySet()){
            values[i] = elem;
            sizes[i] = map.get(elem);
            i++;
        }
        int[] result = new int[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();

        permuteUnique(values, sizes, result, resultList, 0);

        return resultList;
    }

    private void permuteUnique(int[] values, int[] sizes, int[] result, List<List<Integer>> resultList, int level) {

        if(level == result.length){
            List<Integer> temp = new ArrayList<>();
            for(int elem : result){
                temp.add(elem);
            }
            resultList.add(temp);
            return;
        }
        for(int i = 0; i<values.length; i++){
            if(sizes[i] != 0){
                sizes[i] = sizes[i] - 1;
                result[level] = values[i];
                permuteUnique(values, sizes, result, resultList, level+1);
                sizes[i] = sizes[i]+1;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr= {1,2,1};
        PermutationII permutationII = new PermutationII();
        List<List<Integer>> list = permutationII.permuteUnique(arr);
        for(List<Integer> elem : list){
            System.out.println(elem);
        }
    }

}
