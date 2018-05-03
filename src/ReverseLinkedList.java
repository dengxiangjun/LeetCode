/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Reverse a singly linked list.
 * Created by deng on 2018/4/28.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4), n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = reverseList(n1);
        System.out.println(res);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return pre;
    }


//    /**
//     * 迭代
//     *
//     * @param head
//     * @return
//     */
//    public static ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        ListNode pre = null, cur = head, pHead = null;
//        while (cur != null) {
//            ListNode next = cur.next;
//            if (next == null) pHead = cur;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pHead;
//    }

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
