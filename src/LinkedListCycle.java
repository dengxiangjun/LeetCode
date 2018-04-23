/**https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * Created by admin on 2018/4/23.
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(3), l4 = new ListNode(4), l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l4.next = l2;

        boolean res = hasCycle(l1);
        System.out.println(res);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
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
