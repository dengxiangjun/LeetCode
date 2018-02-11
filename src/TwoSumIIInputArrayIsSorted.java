/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p/>
 * <p/>
 * Created by deng on 2018/2/11.
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] res = twoSum(a, 9);
        for (int i : res)
            System.out.println(i);
    }

    public static int[] twoSum(int[] a, int target) {
        int[] res = {0, 0};
        if (a == null || a.length < 2) return res;
        int i = 0, j = a.length - 1;
        while (i < j) {
            int sum = a[i] + a[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }
}
