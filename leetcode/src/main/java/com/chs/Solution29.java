package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/5 9:52
 */
public class Solution29 {

    public static int[] spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        step(0, -1, result, m, n, matrix, 0, 1);

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static boolean check(int x, int y, int m, int n, int[][] matrix) {
        if (x < m && y < n && x >= 0 && y >= 0 && matrix[x][y] != -1) {
            return true;
        }
        return false;
    }

    private static void step(int x, int y, List<Integer> result, int m, int n, int[][] matrix, int a, int b) {

        if (check(x + a, y + b, m, n, matrix)) {
            result.add(matrix[x + a][y + b]);
            matrix[x + a][y + b] = -1;
            step(x + a, y + b, result, m, n, matrix, a, b);
            return;
        }

        int[][] des = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] de : des) {

            if (check(x + de[0], y + de[1], m, n, matrix)) {
                result.add(matrix[x + de[0]][y + de[1]]);
                matrix[x + de[0]][y + de[1]] = -1;
                step(x + de[0], y + de[1], result, m, n, matrix, de[0], de[1]);
                return;
            }
        }
        return;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrder(matrix);
    }
}
