/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p/>
 * For example, given
 * <p/>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p/>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Created by deng on 2018/3/22.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7}, b = {9, 3, 15, 20, 7};
        TreeNode res = buildTree(a, b);
        System.out.println(res);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }

    public static TreeNode construct(int[] preorder, int rootIdx, int[] inorder, int inBegin, int inEnd) {
        if (rootIdx >= preorder.length || inBegin > inEnd) return null;
        int inIdx = inBegin;
        for (int i = inBegin; i <= inEnd; i++) {
            if (preorder[rootIdx] == inorder[i]) {
                inIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[rootIdx]);
        root.left = construct(preorder, rootIdx + 1, inorder, inBegin, inIdx - 1);
        root.right = construct(preorder, rootIdx + inIdx - inBegin + 1, inorder, inIdx + 1, inEnd);
        return root;
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
