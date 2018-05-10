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
        if (head == null || head.next == null) return head;
        quickSort(head, null);
        return head;
    }

    private static void quickSort(ListNode head, ListNode tail) {
        if (head == tail) return;
        ListNode pivot = partition(head, tail);
        quickSort(head, pivot);
        quickSort(pivot.next, tail);
    }

    private static ListNode partition(ListNode head, ListNode tail) {
        int val = head.val;
        ListNode slow = head, fast = head.next;
        while (fast != tail) {
            if (fast.val < val) {
                slow = slow.next;
                swap(slow,fast);
            }
            fast = fast.next;
        }
        swap(slow,head);
        return slow;
    }

    private static void swap(ListNode a, ListNode b){
        int tmp = a.val;
        a.val = b.val;
        b.val  = tmp;
    }
//    /**
//     * 归并排序
//     *
//     * @param head
//     * @return
//     */
//    public static ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode middle = getMiddle(head);
//        ListNode next = middle.next;
//        middle.next = null;
//        return merge(sortList(head), sortList(next));
//    }
//
//    private static ListNode getMiddle(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    private static ListNode merge(ListNode a, ListNode b) {
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (a != null && b!= null){
//            if (a.val < b.val){
//                cur.next = a;
//                a = a.next;
//            }
//            else{
//                cur.next = b;
//                b = b.next;
//            }
//            cur = cur.next;
//        }
//        if (a != null) cur.next = a;
//        else cur.next = b;
//        return dummy.next;
//    }

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
