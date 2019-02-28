/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * description Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/21 18:16
 **/
import java.util.List;
public class FindAllDuplicatesinanArray {

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDuplicates(nums);
        System.out.println(res);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        return null;
    }
}
