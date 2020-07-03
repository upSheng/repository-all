package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/2 16:26
 */
public class Solution378 {

    public static int kthSmallest(int[][] matrix, int k) {

        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left < right) {

            int mid = (left + right) / 2;
            if (help(matrix, k, mid)) {

                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean help(int[][] matrix, int k, int z) {

        int x = matrix.length - 1;
        int y = 0;

        int sum = 0;
        while (x >= 0) {
            if (y < matrix.length && matrix[x][y] <= z) {
                y++;
            } else {
                sum += y;
                x--;
            }
        }
        return sum >= k;

    }

    public static void main(String[] args) {

        int[][] ma = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(ma, 8));
    }
}
