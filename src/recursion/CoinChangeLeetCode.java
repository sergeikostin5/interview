package recursion;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChangeLeetCode {

    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];

        for(int i = 1; i < amount+1; i++){
            cache[i] = -1;
        }
        int result = makeChange(coins, amount, cache);
        if(result == Integer.MAX_VALUE || result == (Integer.MIN_VALUE + 1) || result == Integer.MIN_VALUE){
            return -1;
        }
        return result;
    }

    private int makeChange(int[] coins, int amount, int[] cache){
        if(cache[amount] >= 0) return cache[amount];

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins){
            if(amount - coin >= 0){
                int curMinCoins = makeChange(coins, amount - coin, cache);
                if(curMinCoins < minCoins){
                    minCoins = curMinCoins;
                }
            }
        }
        cache[amount] = minCoins + 1;
        return cache[amount];
    }

    public int makeChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            // Try removing each coin from the total
            // and see which requires the fewest
            // extra coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    int currCoins = cache[i-coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                } }
            cache[i] = minCoins;
        }
        return cache[amount];
    }

//    private int coinChange(int[] coins, int amount, int count, MinWrapper wrapper, int[] cache) {
//        if(amount == 0) {
//            if(count < wrapper.min){
//                wrapper.min = count;
//            }
//            return count;
//        }
//        if(cache[amount] >= 0){
//            return cache[amount];
//        }
//        //Try removing each coin from from the total and see how many more coins are required
//        for(int coin : coins){
//            // skip a coin if it's value is greater than the amount remaining
//            if((amount - coin) >= 0){
//                cache[amount] = coinChange(coins, amount - coin, count+1, wrapper, cache);
//            }
//        }
//        return cache[amount];
//    }

    public int greedy(int[] coins, int amount){
        int counter = 0;
        for(int coin : coins){
            while(amount - coin >= 0){
                counter++;
                amount = amount - coin;
            }
            if(amount == 0) return counter;
        }
        return counter;
    }

    public static void main(String[] args) {

        int[] coins = {2};
        CoinChangeLeetCode ch = new CoinChangeLeetCode();
        int result = ch.coinChange(coins, 3);


    }

}
