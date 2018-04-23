import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * <p/>
 * Return a deep copy of the list.
 * Created by deng on 2018/4/23.
 */
public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;

        r1.random = r2;
        r3.random = r5;
        r4.random = r2;

        RandomListNode res = copyRandomList(r1);
        System.out.println(res);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;

        RandomListNode cur = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        for (Map.Entry<RandomListNode,RandomListNode> entry : map.entrySet()){
            RandomListNode copy = entry.getValue();
            copy.next = map.get(entry.getKey().next);
            copy.random = map.get(entry.getKey().random);
        }
        return map.get(head);


    }


    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
