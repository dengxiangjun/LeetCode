import common.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
 * insert the value into the BST. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Note that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion. You can return any of them.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * This tree is also valid:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 *
 * @author dengxiangjun@jd.com
 * @date 2018/11/5 20:06
 **/
public class InsertintoaBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(7);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        root.left = l;
        l.left = ll;
        l.right = lr;
        root.right = r;
        TreeNode res = insertIntoBST(root, 5);
        System.out.println(res);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}
