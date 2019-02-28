/**
 * https://leetcode.com/problems/can-i-win/description/
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes
 * the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without
 * replacement until they reach a total >= 100.
 * <p>
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player
 * to move can force a win, assuming both players play optimally.
 * <p>
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 * <p>
 * Example
 * <p>
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/11/7 13:39
 **/
public class CanIWin {

    public static void main(String[] args) {
        int maxChoosableInteger = 18;
        int desiredTotal = 79;
        boolean res = canIWin(maxChoosableInteger, desiredTotal);
        System.out.println(res);
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        boolean[] dp = new boolean[desiredTotal + 1 + desiredTotal];
        for (int i = 0; i <= desiredTotal; ) {
            for (int j = 1; j <= maxChoosableInteger; j++) {
                if (i + j <= desiredTotal) dp[i + j] = true;
                for (int k = 1; k <= maxChoosableInteger; k++) {
                    if (k == j) continue;
                    if (i + j + k <= desiredTotal) dp[i + j + k] = false;
                }
                i = i + maxChoosableInteger;
            }
        }
        return dp[desiredTotal];
    }
}
