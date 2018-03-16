/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * <p>
 * Created by deng on 2018/3/16.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a = new int[6];
        a[0] = 1;
        a[1] = 6;
        int[] b = {2, 3, 4, 5};
        merge(a, 2, b, 4);
    }

//    /**
//     * 构造一个新的数组
//     * @param a
//     * @param m
//     * @param b
//     * @param n
//     */
//    public static void merge(int[] a, int m, int[] b, int n) {
//        if (b == null || n == 0) return;
//        int[] c = new int[m];
//        for (int i = 0; i < m; i++) c[i] = a[i];
//        int i = 0, j = 0;
//        while (i < m && j < n) {
//            if (c[i] < b[j]) a[i + j] = c[i++];
//            else a[i + j] = b[j++];
//        }
//        while (i < m) a[i + j] = c[i++];
//        while (j < n) a[i + j] = b[j++];
//    }

    /**
     * 从后往前比较
     *
     * @param a
     * @param m
     * @param b
     * @param n
     */
    public static void merge(int[] a, int m, int[] b, int n) {
        if (b == null || n == 0) return;
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) a[k--] = a[i--];
            else a[k--] = b[j--];
        }
        while (j > -1) a[k--] = b[j--];
    }
}
