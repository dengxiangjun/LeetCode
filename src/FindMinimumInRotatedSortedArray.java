/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * Created by deng on 2018/3/6.
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int res = findMin(a);
        System.out.println(res);
    }

    public static int findMin(int[] a) {
        if (a == null || a.length == 0) return -1;
        int l = 0, r = a.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (a[m] < a[r]) r = m;
            else l = m + 1;
        }
        return Math.min(a[l],a[r]);
    }
}
