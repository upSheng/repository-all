package com.chs;

import java.util.PriorityQueue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/13 17:11
 */
public class SolutionOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int ar : arr) {
            priorityQueue.add(ar);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
