import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p/>
 * Example:
 * <p/>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p/>
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * Created by admin on 2018/4/23.
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

//    /**
//     * 自己的丑陋版本
//     * @param root
//     * @return
//     */
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (root == null) return res;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                res.add(cur.val);
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop().right;
//        }
//        return res;
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
