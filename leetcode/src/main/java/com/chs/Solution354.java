package com.chs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/5 9:56
 */
public class Solution354 {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }

            }
        });

        int res = 0;


        return res;

    }

    public static void main(String[] args) {
        Solution354 solution354 = new Solution354();

        int i = solution354.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}});
        System.out.println(i);
    }
}
