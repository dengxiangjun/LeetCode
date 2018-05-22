/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p/>
 * <p/>
 * For example, the following two linked lists:
 * <p/>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p/>
 * <p/>
 * Notes:
 * <p/>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Created by deng on 2018/5/22.
 */
public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(3), l4 = new ListNode(4), l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l4.next = l2;
//
//        ListNode res = getIntersectionNode(l1,);
//        System.out.println(res);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) return null;
        if (headB == null) return null;
        int cnt1 = 0, cnt2 = 0;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            cnt1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            cnt2++;
            cur2 = cur2.next;
        }
        ListNode longer, shorter;
        int diff = Math.abs(cnt1 - cnt2);
        if (cnt1 > cnt2) {
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
        }
        while (diff > 0) {
            longer = longer.next;
            diff--;
        }
        while (longer != null) {
            if (longer == shorter) return longer;
            else {
                longer = longer.next;
                shorter = shorter.next;
            }
        }
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
