import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 * Created by admin on 2018/3/24.
 */
public class PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1), left = new TreeLinkNode(2), right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeLinkNode(4);
        left.right = new TreeLinkNode(5);
        right.left = new TreeLinkNode(6);
        right.right = new TreeLinkNode(7);
        connect(root);
        System.out.println(1);
    }

//    /**
//     * 使用队列
//     *
//     * @param root
//     */
//    public static void connect(TreeLinkNode root) {
//        if (root == null) return;
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int levelCnt = queue.size();
//            TreeLinkNode next = null, cur;
//            for (int i = 0; i < levelCnt; i++) {
//                cur = queue.poll();
//                cur.next = next;
//                next = cur;
//                queue.add(cur.right);
//                queue.add(cur.left);
//            }
//            queue.removeAll(Collections.singleton(null));
//        }
//    }

    /**
     *
     * @param root
     */
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;//连接2和3
        }
        if (root.next != null && root.right !=null) root.right.next = root.next.left;//连接5和6
        connect(root.left);
        connect(root.right);
    }


    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
