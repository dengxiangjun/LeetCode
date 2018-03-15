import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * https://leetcode.com/problems/partition-list/description/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * <p>
 * Created by admin on 2018/3/15.
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(4), n3 = new ListNode(3), n4 = new ListNode(2), n5 = new ListNode(5), n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode res = partition(n1, 3);
        System.out.println(res);
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode smallerHead = new ListNode(-1), biggerHead = new ListNode(-1),
                cur = head, smallerCur = smallerHead, biggerCur = biggerHead;
        while (cur != null) {
            if (cur.val < x) {
                smallerCur.next = cur;
                smallerCur = smallerCur.next;
            } else {
                biggerCur.next = cur;
                biggerCur = biggerCur.next;
            }
            cur = cur.next;
        }
        smallerCur.next = biggerHead.next;
        biggerCur.next = null;
        return smallerHead.next;
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
