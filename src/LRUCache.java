import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p/>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p/>
 * Example:
 * <p/>
 * LRUCache cache = new LRUCache( 2 capacity );
 * <p/>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * Created by deng on 2018/5/11.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    private class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        else {
            if (node != tail) {
                if (node != head) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                } else {
                    head = head.next;
                }
                tail.next = node;
                node.pre = tail;
                tail = node;
                node.next = null;
            }
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {//已经存在相同的key
            node.val = value;
            if (node != tail) {//不是尾结点，需要把这个节点放到链表的尾部
                if (node != head) {//不是头结点，需要连接该节点的前驱节点和后继结点
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                } else head = head.next;//是头结点，则头结点指针后移
                tail.next = node;//链接到节点尾部
                node.pre = tail;
                tail = node;
                node.next = null;
            }
        } else {//不存在相同的key，插入到链表尾部
            node = new Node(key, value);
            map.put(key, node);//存入hashmap
            if (capacity == 0) {//如果缓存已经满了
                map.remove(head.key);//淘汰掉头结点
                head = head.next;//头指针后移
                capacity++;//容量置1，表示还可以存入一个元素
            }
            if (head == null && tail == null)//链表当前无数据
                head = node;
            else {//链表已经有数据
                tail.next = node;//插入到链表尾部
                node.pre = tail;
                node.next = null;
            }
            tail = node;//尾指针指向当前插入的结点
            capacity--;//容量减1
        }
    }
}
