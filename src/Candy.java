/**
 * https://leetcode.com/problems/candy/description/
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p/>
 * Example 1:
 * <p/>
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p/>
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * Created by deng on 2018/4/23.
 */
public class Candy {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 2};
        int res = candy(a);
        System.out.println(res);
    }

    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) dp[i] = dp[i + 1] + 1;
        }
        int res = 0;
        for (int item : dp) res += item;
        return res;
    }
}
