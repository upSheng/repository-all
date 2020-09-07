package com.chs;

import java.util.PriorityQueue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/13 13:44
 */
public class Solution703 {

    private int k;
    private PriorityQueue<Integer> priorityQueue;

    public Solution703(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {


        if (priorityQueue.size() == k) {
            priorityQueue.add(val);
            priorityQueue.poll();
        }else {
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}
