import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * Created by admin on 2018/3/23.
 */
public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1), left = new TreeNode(2), right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        //right.left = new TreeNode(6);
        right.right = new TreeNode(6);
        flatten(root);
        int a = 1;
    }


//    private static TreeNode prev = null;
//
//    /**
//     * 后序遍历的翻版，先遍历右子树，再遍历左子树
//     *
//     * @param root
//     */
//    public static void flatten(TreeNode root) {
//        if (root == null) return;
//        flatten(root.right);
//        flatten(root.left);
//        root.right = prev;
//        root.left = null;
//        prev = root;
//    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if (!stack.isEmpty()){
                cur.right = stack.peek();
            }
            cur.left = null;
        }
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
