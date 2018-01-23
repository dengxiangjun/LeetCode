/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Created by deng on 2018/1/23.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(4), r1 = new ListNode(1), r2 = new ListNode(3), r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        r1.next = r2;
        r2.next = r3;
        ListNode[] lists = {l1, r1};

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left < right) {
            int mid = (left + right) / 2;
            ListNode l1 = mergeKLists(lists, left, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, right);
            return merge(l1, l2);
        }
        return null;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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
//    /**
//     * 超时
//     * @param lists
//     * @return
//     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        ListNode preHead = new ListNode(-1), pre = preHead;
//        boolean flag = true;
//        while (flag) {
//            int min = Integer.MAX_VALUE,minIndex = 0;
//            for (int i = 0; i < lists.length; i++) {
//                ListNode node = lists[i];
//                if (node != null && min > node.val){
//                    min = node.val;
//                    minIndex = i;
//                }
//            }
//            if (min == Integer.MAX_VALUE) flag = false;
//            else {
//                pre.next = new ListNode(min);
//                pre = pre.next;
//                lists[minIndex] = lists[minIndex].next;
//            }
//        }
//        return preHead.next;
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
