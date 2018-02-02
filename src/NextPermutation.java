/**
 * https://leetcode.com/problems/next-permutation/description/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p/>
 * Created by deng on 2018/1/30.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] a = {1,5,1};
        int[] result = nextPermutation(a);
        System.out.println(result);
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[i] < nums[j]) j++;
            j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            int tmp = nums[j];
            nums[j] = nums[k];
            nums[k] = tmp;
            j++;
            k--;
        }
        return nums;
    }
}
