/**
 * https://leetcode.com/problems/majority-element/description/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p/>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * Created by deng on 2018/5/25.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        int res = majorityElement(a);
        System.out.print(res);
    }

    public static int majorityElement(int[] a) {
        int mid = a.length / 2;
        int index = partition(a, 0, a.length - 1);
        while (index != mid) {
            if (index > mid) index = partition(a, 0, index - 1);
            else index = partition(a, index + 1, a.length - 1);
        }
        return a[mid];
    }

    public static int partition(int[] a, int start, int end) {
        int temp = a[start];
        int i = start;
        int small = start;
        while (i <= end) {
            if (a[i] < temp) {
                int swap = a[small];
                a[small++] = a[i];
                a[i] = swap;
            }
            i++;
        }
        a[small] = temp;
        return small;
    }
}
