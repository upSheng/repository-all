package com.chs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/2 14:40
 */
public class Solution225 {

    private Queue<Integer> queue;

    public Solution225() {

        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {

        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return queue.isEmpty();
    }
}
