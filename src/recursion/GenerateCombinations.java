package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 4/1/18.
 */
public class GenerateCombinations {

    public List<String> combinations(int[] nums){
        List<String> result = new ArrayList<>();
        combinations(nums, "", result);
        return result;
    }

    private void combinations(int[] nums, String s, List<String> result) {
        if(s.length() == nums.length) {
            result.add(s);
            return;
        }
        for(int j = 0; j < nums.length; j++){
            combinations(nums, s + nums[j], result);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        GenerateCombinations gc = new GenerateCombinations();

        List<String> result = gc.combinations(nums);
        for(String s : result){
            System.out.println(s);
        }
    }
}
