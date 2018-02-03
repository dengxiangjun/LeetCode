/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p/>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * Write a function to determine if a given target is in the array.
 * <p/>
 * The array may contain duplicates.
 * <p/>
 * <p/>
 * Created by deng on 2018/2/3.
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] a = {1};
        boolean result = search(a, 0);
        System.out.println(result);
    }

    public static boolean search(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == target)
                return true;
            if (a[m] < target && target < a[r]) l = m + 1;
            else if (a[m] > target && target > a[l]) r = m - 1;
            else {
                if (a[l] == target) return true;
                else l++;
                if (a[r] == target) return true;
                else r--;
            }
        }
        return false;
    }
}
