/**
 * https://leetcode.com/problems/search-for-a-range/description/
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * Created by deng on 2018/2/3.
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] a = {2, 2};
        int[] result = searchRange(a, 2);
        for (int i : result) System.out.println(i);
    }

    public static int[] searchRange(int[] a, int target) {
        int[] res = {-1, -1};
        if (a == null || a.length == 0) return res;

        int start = binarySearch(a, target);
        if (start == a.length || a[start] != target) return res;//没找到

        int end = binarySearch(a, target + 1) - 1;
        res[0] = start;
        res[1] = end;
        return res;
    }

    public static int binarySearch(int[] a, int target) {
        int l = 0, r = a.length;//使用r = a.length使得{2,2}查找3失败时能够返回位置3，如果使用r = a.length - 1将使得查找3失败时返回位置2
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (target > a[m]) l = m + 1;
            else r = m;
        }
        return l;
    }
}
