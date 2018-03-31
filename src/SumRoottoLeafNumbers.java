/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 * <p>
 * <p>
 * Created by admin on 2018/3/31.
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return num * 10 + root.val;
        return dfs(root.left, num * 10 + root.val) + dfs(root.right, num * 10 + root.val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
