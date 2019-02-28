/**
 * description TODO
 *
 * @author dengxiangjun@jd.com
 * @date 2018/11/7 23:23
 **/

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = fourSum(arr, -1);
        System.out.println(res);
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(target - nums[i], i + 1, nums, res);
        }
        return new ArrayList<List<Integer>>(res);
    }

    private static void threeSum(int sum, int start, int[] nums, Set<List<Integer>> res) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = start; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (hashSet.contains(sum - nums[i] - nums[j])) {
                    List<Integer> item = new ArrayList<>();
                    item.add(-sum);
                    item.add(nums[i]);
                    item.add(sum - nums[i] - nums[j]);
                    item.add(nums[j]);
                    res.add(item);
                } else {
                    hashSet.add(nums[i]);
                    hashSet.add(nums[j]);
                }
            }
        }
    }

//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return new ArrayList<>();
//        Arrays.sort(nums);
//        Set<List<Integer>> res = new HashSet<>();
//        for (int i = 0; i < nums.length - 3; i++) {
//            for (int j = i + 1; j < nums.length - 2; j++) {
//                Set<Integer> set = new HashSet<>();
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (set.contains(target - nums[k] - nums[i] - nums[j])) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        list.add(target - nums[k] - nums[i] - nums[j]);
//                        res.add(list);
//                    } else set.add(nums[k]);
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }

//    private static void threeSum(int[] nums, int start, int target, List<List<Integer>> res) {
//        for (int i = start; i < nums.length - 2; i++) {
//            //if (i > 0 && nums[i + 1] == nums[i]) continue;
//            twoSum(nums, i + 1, target - nums[i], res);
//        }
//    }
//
//    private static void twoSum(int[] nums, int start, int target, List<List<Integer>> res) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = start; i < nums.length; i++) {
//            if (set.contains(target - nums[i])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(target - nums[i]);
//                list.add(nums[i]);
//                list.add(nums[start - 1]);
//                list.add(-(target + nums[start - 1]));
//                res.add(new ArrayList<>(list));
//            } else set.add(nums[i]);
//        }
//    }



}
