/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * Remove all elements from a linked list of integers that have value val.
 * <p/>
 * Example:
 * <p/>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * Created by deng on 2018/5/30.
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(6), n4 = new ListNode(3), n5 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = removeElements(n1, 1);
        System.out.println(res);
    }

//    /**
//     * 迭代实现
//     * @param head
//     * @param val
//     * @return
//     */
//    public static ListNode removeElements(ListNode head, int val) {
//        if (head == null) return null;
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy, cur = head;
//        while (cur != null) {
//            if (cur.val == val) pre.next = cur.next;
//            else pre = cur;
//            cur = cur.next;
//        }
//        return dummy.next;
//    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
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
