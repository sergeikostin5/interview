package dynamic;

/**
 * Created by sergei.kostin on 4/4/18.
 */
public class Paint_House_256 {

    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int length = costs.length - 1;
        int[] memo = new int[costs[0].length];
        memo[0] = costs[length][0];
        memo[1] = costs[length][1];
        memo[2] = costs[length][2];
        for(int i = length - 1; i >= 0; i--){
            int red = memo[0]; int blue = memo[1]; int green = memo[2];
            memo[0] = Math.min(costs[i][0] + blue, costs[i][0] + green);
            memo[1] = Math.min(costs[i][1] + red, costs[i][1] + green);
            memo[2] = Math.min(costs[i][2] + red, costs[i][2] + blue);
        }

        return Math.min(Math.min(memo[0], memo[1]), memo[2]);
    }

    public static void main(String[] args) {
        Paint_House_256 paintHouse256 = new Paint_House_256();
        int[][] arr = {{20,18,4},{9,9,10}};
        System.out.println(paintHouse256.minCost(arr));
    }

}
