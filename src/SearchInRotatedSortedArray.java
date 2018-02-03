/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 * Created by deng on 2018/2/2.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3};
        int result = search(a, 3);
        System.out.println(result);
    }

    public static int search(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == target) return m;
            if (a[m] < a[r]) {
                if (a[m] < target && target <= a[r]) l = m + 1;
                else r = m - 1;
            } else {
                if (a[m] > target && target >= a[l]) r = m - 1;
                else l = m + 1;
            }

        }
        return -1;
    }
}
