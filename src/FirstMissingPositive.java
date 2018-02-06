/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p/>
 * <p/>
 * Created by deng on 2018/2/6.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] a = {1, 2, 0};
        int res = firstMissingPositive(a);
        System.out.println(res);
    }

    /**
     * 计数排序的思想
     *
     * @param a
     * @return
     */
    public static int firstMissingPositive(int[] a) {
        if (a == null || a.length == 0) return 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] <= a.length && a[a[i] - 1] != a[i]) {
                int tmp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = tmp;
                i--;//交换后，为了不错过与a[i]交换的字符，i需要回溯
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != i + 1) return i + 1;
        }
        return a.length + 1;
    }
}
