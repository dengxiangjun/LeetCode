/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * Created by deng on 2018/1/23.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4}, nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;
        if (len % 2 == 1) return find(nums1, 0, nums2, 0, len / 2 + 1);
        else return (find(nums1, 0, nums2, 0, len / 2) + find(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }

    public static int find(int[] a, int startA, int[] b, int startB, int k) {
        if (startA >= a.length) return b[startB + k - 1];
        if (startB >= b.length) return a[startA + k - 1];
        if (k == 1) return Math.min(a[startA], b[startB]);
        int x = startA + k / 2 - 1 < a.length ? a[startA + k / 2 - 1] : Integer.MAX_VALUE,
                y = startB + k / 2 - 1 < b.length ? b[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (x < y) {
            return find(a, startA + k / 2, b, startB, k - k / 2);
        } else
            return find(a, startA, b, startB + k / 2, k - k / 2);
    }
}
