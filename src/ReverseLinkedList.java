/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Reverse a singly linked list.
 * Created by deng on 2018/4/28.
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        return null;
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
