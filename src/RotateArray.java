import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/description/
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p/>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p/>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * Created by deng on 2018/5/27.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] a = {-1};
        rotate(a, 2);
    }

    /**
     * 方法1
     * @param a
     * @param k
     */
    public static void rotate(int[] a, int k) {
        k %= a.length;
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        for (int i = k, j = a.length - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

//    /**
//     * 超时
//     * @param a
//     * @param k
//     */
//    public static void rotate(int[] a, int k) {
//        while (k-- > 0) {
//            for (int i = 1; i < a.length; i++) {
//                int temp = a[i];
//                a[i] = a[0];
//                a[0] = temp;
//            }
//        }
//    }
}
