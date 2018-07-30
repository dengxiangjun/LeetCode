/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of K.
 * Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
 * If the pile has less than K bananas, she eats all of them instead,
 * and won't eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int H = 9;
        int res = minEatingSpeed(piles, H);
        System.out.println(res);
    }

    public static int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0) return 0;
        int max = 0;
        for (int item : piles) max = Math.max(item, max);
        if (H == piles.length) return max;//超过堆的个数，返回最大速度
        int low = 1, high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int hour = count(piles, mid);
            if (hour > H) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int count(int[] piles, int speed) {
        int hour = 0;
        for (int item : piles) {
            hour  += (item / speed) + (item % speed == 0 ? 0 : 1);
        }
        return hour;
    }
}
