/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * Example:
 * <p/>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * Created by deng on 2018/1/21.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(4), r1 = new ListNode(1), r2 = new ListNode(3), r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        r1.next = r2;
        r2.next = r3;
        ListNode result = mergeTwoLists(l1, r1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
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
