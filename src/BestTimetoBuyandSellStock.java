/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p>
 * In this case, no transaction is done, i.e. max profit = 0.
 * Created by admin on 2018/3/29.
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 1};
        int res = maxProfit(a);
        System.out.println(res);
    }

    public static int maxProfit(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    res = Math.max(res,a[j] - a[i]);
                }
            }
        return res;
    }
}
