/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 * <p/>
 * <p/>
 * Example:
 * <p/>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p/>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p/>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * Created by deng on 2018/3/23.
 */
public class ConvertSortedListtoBinarySearchTree {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-10), n2 = new ListNode(-3), n3 = new ListNode(0), n4 = new ListNode(5), n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        TreeNode res = sortedListToBST(n1);
        System.out.println(res);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = construct(head, null);
        return root;
    }

    public static TreeNode construct(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = construct(head, slow);
        root.right = construct(slow.next, tail);
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
