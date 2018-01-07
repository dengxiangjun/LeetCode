package com.dxj.tp;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 * <p>
 * <p>
 * Created by deng on 2017/11/13.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS(a);
        System.out.println(result);
    }

    public static int lengthOfLIS(int[] a) {
        int n = a.length, maxLen = 1;
        if (n == 0) return 0;
        int[] maxLenArr = new int[n];
        for (int i = 0; i < n; i++) maxLenArr[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    maxLenArr[i] = Math.max(maxLenArr[i], maxLenArr[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, maxLenArr[i]);
        }
        return maxLen;
    }
}
