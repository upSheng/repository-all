package com.chs;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/17 15:44
 */
public class Solution1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] res = new int[R * C][];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[C * i + j] = new int[]{i, j};
            }
        }

        Arrays.sort(res, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[1] - r0) - Math.abs(o2[1] - c0));
        return res;
    }
}
