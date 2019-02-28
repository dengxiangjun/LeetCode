import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 * description You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/20 17:27
 **/
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i == coin) dp[i] = 1;
                else if (i - coin >= 0 && dp[i - coin] != -1){
                   if (dp[i] == -1) dp[i] = dp[i - coin] + 1;
                   else dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }
}
