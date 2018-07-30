/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to search: 2
 * You should return this subtree:
 * <p>
 * 2
 * / \
 * 1   3
 * In the example above, if we want to search the value 5,
 * since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would
 * see the expected output (serialized tree format) as [], not null.
 */
public class SearchinaBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(18), left = new TreeNode(2), right = new TreeNode(22);
        root.left = left;
        root.right = right;

        right.right = new TreeNode(63);
        right.right.right = new TreeNode(84);
        TreeNode res = searchBST(root, 63);
        System.out.println(res);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
       if (root == null || root.val == val) return root;
       if (root.val > val) return searchBST(root.left,val);
       else return searchBST(root.right,val);
    }

//    public static void dfs(TreeNode root, int val, TreeNode[] res) {
//        if (root == null) return;
//        if (root.val == val) {
//            res[0] = root;
//            return;
//        }
//        if (root.left != null) dfs(root.left,val,res);
//        if (root.right != null) dfs(root.right,val,res);
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
