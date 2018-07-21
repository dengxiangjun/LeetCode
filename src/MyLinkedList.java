/**
 * https://leetcode.com/problems/design-linked-list/description/
 * Design your implementation of the linked list. You can choose to use the singly
 * linked list or the doubly linked list. A node in a singly linked list
 * should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node. If you want to use the doubly linked list,
 * you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class MyLinkedList {

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
       // linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(0)); // returns 2
        //linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(2));            // returns 3
    }

    private Node head;

    private class Node {
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) return -1;
        else {
            Node cur = head;
            while (cur != null) {
                if (index == 0) return cur.val;
                cur = cur.next;
                index--;
            }
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) head = node;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node
     * will be appended to the end of linked list.
     * If index is greater than the length,
     * the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (head == null) {
            if (index > 0) return;
            head = node;
        } else {
            Node dummy = new Node();
            dummy.next = head;
            Node pre = dummy, cur = head;
            while (cur != null){
               if (index == 0){
                   pre.next = node;
                   node.next = cur;
               }
               pre = cur;
               cur = cur.next;
               index--;
            }
            if (index == 0) pre.next = node;
            head = dummy.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head != null){
            Node dummy = new Node();
            dummy.next = head;
            Node pre = dummy, cur = head;
            while (cur != null){
                if (index == 0){
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
                index--;
            }

            head = dummy.next;
        }
    }
}
