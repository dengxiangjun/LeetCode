import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * Created by admin on 2018/5/18.
 */
public class ImplementStackusingQueues {

    Queue<Integer> queue1, queue2;

    //定义两个栈，不区分作用，但是有一个原则就是始终要保证其中一个栈为空。
    // 每次插入的时候先将待插入数据直接插入到空的栈中，
    // 然后再将另外一个栈中的数据依次弹出，并压入这个刚刚插入新数据的栈中。
    // 弹出的时候，只要从那个有数据的栈中往外弹数据就可以了。

    /**
     * Initialize your data structure here.
     */
    public ImplementStackusingQueues() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(x);
            return;
        }
        if (queue1.isEmpty()){
            queue1.offer(x);
            while (!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
        }else {
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()){
            return -1;
        }
        return !queue1.isEmpty() ? queue1.poll() : queue2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()){
            return -1;
        }
        return !queue1.isEmpty() ? queue1.peek() : queue2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
