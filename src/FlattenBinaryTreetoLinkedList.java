import java.util.List;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
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
    }

    public static void flatten(TreeNode root) {

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
