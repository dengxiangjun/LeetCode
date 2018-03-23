/**
 * https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p>
 * <p>
 * Created by deng on 2018/3/23.
 */
public class PathSum {

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
        boolean res = hasPathSum(root, 22);
        System.out.println(res);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return (root.val == sum);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
