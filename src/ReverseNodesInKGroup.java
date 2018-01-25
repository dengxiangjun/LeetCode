/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * <p>
 * Created by deng on 2018/1/25.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4), n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = reverseKGroup(n1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(-1), cur = preHead;
        preHead.next = head;
        while (cur.next != null) {
            cur = reverse(cur, k);
        }
        return preHead.next;
    }

    public static ListNode reverse(ListNode subHead, int k) {
        ListNode head = subHead.next, pre = subHead.next, cur = subHead.next;
        while (cur != null) {
            ListNode pNext = cur.next;
            if (pNext == null && k == 1) subHead.next = cur;
            k--;
            cur.next = pre;
            pre = cur;
            cur = pNext;
        }
        return head;
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
