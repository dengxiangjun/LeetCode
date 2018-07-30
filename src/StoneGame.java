/**
 * https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.
 * The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.
 * Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * Example 1:
 * <p>
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 */
public class StoneGame {

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        boolean res = stoneGame(piles);
        System.out.println(res);
    }

    public static boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int item : piles) sum += item;
        return dfs(piles, 0, sum, 0, 0, piles.length - 1);
    }

    public static boolean dfs(int[] piles, int sum1, int sum, int type, int left, int right) {
        if (sum1 >= (sum / 2)) return true;
        if (left > right) return sum1 > (sum - sum1) ;
        if (type == 0) {
            return dfs(piles, sum1 + piles[left], sum, 1, left + 1, right)
                    || dfs(piles, sum1 + piles[right], sum, 1, left, right - 1);
        } else {
            return dfs(piles, sum1, sum - piles[left], 0, left + 1, right)
                    || dfs(piles, sum1, sum - piles[right], 0, left, right - 1);
        }
    }
}
