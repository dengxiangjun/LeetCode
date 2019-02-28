import java.util.*;

/**
 * https://leetcode.com/problems/coin-change-2/
 * description You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Note: You can assume that
 * <p>
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/20 18:15
 **/
public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int res = change(amount, coins);
        System.out.println(res);
    }
    
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] >= 0 ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

//    /**
//     * dfs
//     * @param amount
//     * @param coins
//     * @return
//     */
//    public static int change(int amount, int[] coins) {
//        Set<List<Integer>> set = new HashSet<>();
//        dfs(amount, coins, set, new ArrayList<>());
//        return set.size();
//    }
//
//    private static void dfs(int amount, int[] coins,  Set<List<Integer>> set, List<Integer> list) {
//        if (amount < 0) return;
//        if (amount == 0) {
//            Collections.sort(list);
//            set.add(list);
//            return;
//        }
//        for (int coin : coins){
//            List<Integer> tmp = new ArrayList(list);
//            tmp.add(coin);
//            dfs(amount - coin, coins, set, tmp);
//        }
//    }
}
