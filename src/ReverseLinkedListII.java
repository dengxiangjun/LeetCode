/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * <p>
 * Created by deng on 2018/3/16.
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4), n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = reverseBetween(n1, 2, 4);
        System.out.println(res);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode subHead = head, subPre = dummy;
        while (m > 1) {
            subPre = subHead;
            subHead = subHead.next;
            m--;
            n--;
        }
        ListNode subTail = subHead;
        while (n > 1) {
            subTail = subTail.next;
            n--;
        }
        ListNode subNext = subTail.next;

        ListNode pre = subNext, cur = subHead;
        while (cur == subNext) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        subPre.next = pre;
        return dummy.next;
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
