import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p/>
 * Calling next() will return the next smallest number in the BST.
 * <p/>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Created by deng on 2018/5/25.
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(root);
        int res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
        res = binarySearchTreeIterator.next();
        System.out.println(res);
    }

    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return val;
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
