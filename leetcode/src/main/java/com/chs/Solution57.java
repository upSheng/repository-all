package com.chs;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {

    public static void main(String[] args) {

        System.out.println(findContinuousSequence(9));
    }

    public static int[][] findContinuousSequence(int target) {

        int left = 0;
        int right = 1;

        int temp;

        List<int[]> result = new ArrayList<>();

        while (left < right && right < (target / 2 + 2)) {
            temp = ((left + right) * (right - left + 1)) / 2;

            if (temp == target) {

                int[] node = new int[right - left + 1];

                int index = left;
                for (int i = 0; i < right - left + 1; i++) {
                    node[i] = index;
                    index++;
                }
                result.add(node);
                left++;
            } else if (temp < target) {
                right++;
            } else {
                left ++;
            }
        }

        int[][] res = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;

    }
}
