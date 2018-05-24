/**
 * https://leetcode.com/problems/find-peak-element/description/
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Created by admin on 2018/5/23.
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] a = {1,2};
        int res = findPeakElement(a);
        System.out.println(res);
    }

    public static int findPeakElement(int[] a) {
        if (a == null || a.length == 0) return -1;
        if (a.length == 1 && a[0] == Integer.MIN_VALUE) return 0;
        for (int i = 0; i < a.length; i++) {
            int left = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int right = i == a.length - 1 ? Integer.MIN_VALUE : a[i + 1];
            if (a[i] > left && a[i] > right) return i;
        }
        return -1;
    }
}
