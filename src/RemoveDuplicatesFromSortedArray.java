/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 * Created by deng on 2017/11/6.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 5};
        int result = removeDuplicates(a);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] a) {
        if (a.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                i++;
                a[i] = a[j];
            }

        }
        return i + 1;
    }
}
