package recursion;

/**
 * Created by sergei.kostin on 2/11/18.
 */
public class CoinChange {

    public int changeWays(int[] nums, int n){
        return changeWays(nums, n, 0);
    }

    private int changeWays(int[] nums, int n, int current){
        if(n == 0) return 1;
        if(n < 0) return 0;

        int count = 0;
        for(int i = current; i < nums.length; i++){
            count += changeWays(nums, n - nums[i], i);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,1};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.changeWays(nums, 20));
    }
}
