package com.chs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/18 15:56
 */
public class Solution264 {
    public int nthUglyNumber(int n) {

        int[] result = new int[n];
        result[0] = 1;
        int a = 0, b = 0, c = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        priorityQueue.add(new int[]{2, 0});
        priorityQueue.add(new int[]{3, 1});
        priorityQueue.add(new int[]{5, 2});

        for (int i = 1; i < n; i++) {

            int[] poll = priorityQueue.poll();
            result[i] = poll[0];

            if (poll[1] == 0) {
                a++;
                priorityQueue.add(new int[]{result[a] * 2, 0});
            }
            if (poll[1] == 1) {
                b++;
                priorityQueue.add(new int[]{result[b] * 3, 1});
            }
            if (poll[1] == 2) {
                c++;
                priorityQueue.add(new int[]{result[c] * 5, 2});
            }
        }

        return result[n - 1];

    }

    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        solution264.nthUglyNumber(10);

    }
}
