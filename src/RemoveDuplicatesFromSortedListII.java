/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * Created by admin on 2018/3/14.
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(1), n3 = new ListNode(2), n4 = new ListNode(2), n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = deleteDuplicates(n1);
        System.out.println(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1), slow = dummyHead, fast = head;
        dummyHead.next = head;
        while (fast != null) {
            while (fast.next != null && fast.next.val == slow.next.val) fast = fast.next;
            if (slow.next == fast) slow = slow.next;
            else slow.next = fast.next;
            fast = fast.next;
        }
        return dummyHead.next;
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
