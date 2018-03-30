/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Created by admin on 2018/3/29.
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] a = {7, 6, 5, 3, 4, 1};
        int res = maxProfit(a);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = Integer.MAX_VALUE, localMax = 0;
        int[] left = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else {
                localMax = Math.max(localMax, prices[i] - min);
            }
            left[i] = localMax;
        }

        min = Integer.MAX_VALUE;
        localMax = 0;
        int[] right = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] < min) min = prices[i];
            else localMax = Math.max(localMax,0 );
        }
        return res;
    }
}
