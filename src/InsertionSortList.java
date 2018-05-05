/**
 * https://leetcode.com/problems/insertion-sort-list/description/
 * Sort a linked list using insertion sort.
 * <p/>
 * <p/>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p/>
 * <p/>
 * Algorithm of Insertion Sort:
 * <p/>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p/>
 * Example 1:
 * <p/>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p/>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * Created by admin on 2018/4/23.
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4), l2 = new ListNode(2), l3 = new ListNode(1), l4 = new ListNode(8), l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = insertionSortList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 单链表的插入排序
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), node = head;
        while (node != null) {
            ListNode pre = dummyHead,cur = dummyHead.next;
            while (cur != null && cur.val < node.val) {
                pre = pre.next;
                cur = cur.next;
            }
            ListNode next = node.next;
            node.next = cur;
            pre.next = node;
            node = next;
        }
        return dummyHead.next;
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
