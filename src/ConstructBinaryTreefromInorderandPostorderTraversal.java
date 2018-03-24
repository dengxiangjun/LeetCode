/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p/>
 * For example, given
 * <p/>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p/>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Created by deng on 2018/3/23.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {
        int[] a = {9, 3, 15, 20, 7}, b = {9, 15, 7, 20, 3};
        TreeNode res = buildTree(a, b);
        System.out.println(res);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = contruct(inorder, 0, inorder.length - 1, postorder, inorder.length - 1);
        return root;
    }

    public static TreeNode contruct(int[] inorder, int inStart, int inEnd, int[] postorder, int postIdx) {
        if (postIdx < 0 || inStart > inEnd) return null;
        int rootVal = postorder[postIdx], rootIdx = inEnd;
        for (int i = inEnd; i >= inStart; i--) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.right = contruct(inorder, rootIdx + 1, inEnd, postorder, postIdx - 1);
        root.left = contruct(inorder, inStart, rootIdx - 1, postorder, postIdx - (inEnd - rootIdx) - 1);
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
