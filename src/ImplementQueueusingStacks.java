import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * Created by admin on 2018/5/18.
 */
public class ImplementQueueusingStacks {
    //定义两个栈，一个专门用来插入，一个专门用来弹出。
    // 插入操作只会插入到插入栈。弹出的时候，优先从弹出栈往外弹，
    // 如果弹出栈中的内容为空，那么就将插入栈中的数据依次弹出，
    // 并压入弹出栈，然后再弹出。

    Stack<Integer> stack1,stack2;

    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) transfer();
        return stack2.pop();
    }

    public void transfer(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) transfer();
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
