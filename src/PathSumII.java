import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/description/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * Created by deng on 2018/3/23.
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5), left = new TreeNode(4), right = new TreeNode(8);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(11);
        left.left.left = new TreeNode(7);
        left.left.right = new TreeNode(2);
        //left.right = new TreeNode(9);
        right.left = new TreeNode(13);
        right.right = new TreeNode(4);
        right.left.left = new TreeNode(1);
        List<List<Integer>> res = pathSum(root, 22);
        System.out.println(res);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> item = new LinkedList<Integer>();
        dfs(res, item, root, sum);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> item, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new LinkedList<>(item));
            }
            return;
        }
        if (root.left != null) {
            item.add(root.left.val);
            dfs(res, item, root, sum - root.left.val);
            item.remove(item.size() - 1);
        }

        if (root.right != null) {
            item.add(root.right.val);
            dfs(res, item, root, sum - root.right.val);
            item.remove(item.size() - 1);
        }
        return;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
