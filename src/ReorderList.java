/**
 * https://leetcode.com/problems/reorder-list/description/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * Created by admin on 2018/4/23.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(3), l4 = new ListNode(4), l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        reorderList(l1);
        System.out.println(1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode afterHead = null, prev = null, cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) afterHead = cur;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode cur1 = head, cur2 = afterHead;
        while (cur1 != slow && cur2 != null) {
            ListNode next1 = cur1.next,next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
        slow.next = null;
    }

    private static class ListNode {
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
