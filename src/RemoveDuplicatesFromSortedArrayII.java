/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 * Created by admin on 2018/3/12.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 5};
        int res = removeDuplicates(a);
        System.out.println(res);
    }


    public static int removeDuplicates(int[] a) {
        if (a == null) return 0;
        if (a.length < 3) return a.length;
        int i = 0;
        for (int item : a) {
            if (i < 2 || item > a[i - 2]) a[i++] = item;
        }
        return i;
    }
}
