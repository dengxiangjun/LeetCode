/**
 * https://leetcode.com/problems/sort-list/description/
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p/>
 * Example 1:
 * <p/>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p/>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * Created by deng on 2018/5/5.
 */
public class SortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4), l2 = new ListNode(2), l3 = new ListNode(1), l4 = new ListNode(8), l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = sortList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        return null;
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
