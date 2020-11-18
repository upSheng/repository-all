package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/18 20:13
 */
public class Solution232 {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public Solution232() {

        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        stack1.push(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return stack1.isEmpty() && stack2.isEmpty();
    }
}
