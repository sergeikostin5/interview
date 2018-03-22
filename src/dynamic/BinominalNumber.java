package dynamic;

/**
 * Created by sergei.kostin on 2/16/18.
 */
public class BinominalNumber {

    public void printBinominalNumber(int n){

        int[][] nums = new int[n+1][n+1];
        nums[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <=i; j++){
                if(j == 0) nums[i][j] = 1;
                else{
                    nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
                    if(i == n) System.out.print(nums[i][j] + "|");
                }
            }
        }
    }

    public static void main(String[] args) {
        BinominalNumber bn = new BinominalNumber();
        bn.printBinominalNumber(6);
    }

}
