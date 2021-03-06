/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * <p>
 * Created by admin on 2018/3/14.
 */
public class RemoveDuplicatesFromSortedList {

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
            while (fast.next != null && slow.next.val == fast.next.val) fast = fast.next;
            slow.next = fast;
            slow = fast;
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
