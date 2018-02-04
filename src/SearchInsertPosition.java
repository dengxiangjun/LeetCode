/**
 * https://leetcode.com/problems/search-insert-position/description/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p/>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p/>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * <p/>
 * Input: [1,3,5,6], 0
 * Output: 0
 * Created by deng on 2018/2/4.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 5, 6};
        int result = searchInsert(a, 6);
        System.out.println(result);
    }

    public static int searchInsert(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (a[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
