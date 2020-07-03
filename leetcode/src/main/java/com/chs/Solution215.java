package com.chs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/29 10:06
 */
public class Solution215 {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y)->y-x);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i= 1; i<k ; i++){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{1, 2, 6, 5, 4}, 2);
        System.out.println(kthLargest);
    }

}
