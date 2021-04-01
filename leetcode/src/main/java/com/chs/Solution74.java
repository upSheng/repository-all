package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/30 9:21
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;

        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }
        int index1, index2;
        while (start < end) {
            int cur = (start + end) / 2;

            index1 = cur == 0 ? 0 : (int) Math.ceil(cur / n) - 1;
            index2 = cur % n == 0 ? n - 1 : cur % n;

            if (matrix[index1][index2] == target) {
                return true;
            }
            if (matrix[index1][index2] < target) {

                start = cur + 1;
            }
            if (matrix[index1][index2] > target) {

                end = cur;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[][] ma = new int[][]{
                {1, 1}
        };
        Solution74 solution74 = new Solution74();
        solution74.searchMatrix(ma, 13);
    }


}
