package com.chs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {


    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {

        queue = new LinkedList();
        deque = new LinkedList();
    }

    public int max_value() {

        return deque.size() > 0 ? deque.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);

        while (deque.size() > 0 && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {

        int v = queue.size()>0?queue.poll():-1;

        if (deque.size() > 0 && v == deque.peek()) {
            deque.poll();
        }

        return v;
    }
}
