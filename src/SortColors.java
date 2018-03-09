/**
 * https://leetcode.com/problems/sort-colors/description/
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * Created by deng on 2018/3/9.
 */
public class SortColors {

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 2, 0, 1, 2, 0};
        sortColors(a);
    }

//    /**
//     * 计数
//     * @param a
//     */
//    public static void sortColors(int[] a) {
//        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == 0) cnt0++;
//            else if (a[i] == 1) cnt1++;
//            else cnt2++;
//        }
//        int i = 0;
//        while (i < cnt0) a[i++] = 0;
//        while (i - cnt0 < cnt1) a[i++] = 1;
//        while (i - cnt0 - cnt1 < cnt2) a[i++] = 2;
//    }

    /**
     * 双指针
     *
     * @param a
     */
    public static void sortColors(int[] a) {
        int zero = 0, two = a.length - 1;
        while (zero < a.length && a[zero] == 0) zero++;
        while (two >= zero && a[two] == 2) two--;
        int index = zero;
        while (index <= two) {
            if (a[index] == 0) {
                a[index++] = a[zero];
                a[zero++] = 0;
            } else if (a[index] == 1) index++;
            else {
                a[index] = a[two];
                a[two--] = 2;
            }
        }
    }
}
