import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * Created by admin on 2018/4/23.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
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
