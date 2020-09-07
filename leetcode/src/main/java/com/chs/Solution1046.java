package com.chs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/13 14:21
 */
public class Solution1046 {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        int a,b;
        while (priorityQueue.size() != 1) {
            a = priorityQueue.poll();
            b = priorityQueue.poll();
            priorityQueue.add(Math.abs(a - b));
        }
        return priorityQueue.peek();
    }
}
