import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p/>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p/>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 * Created by deng on 2018/3/22.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        int res = maxDepth(root);
        System.out.println(res);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth;
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
