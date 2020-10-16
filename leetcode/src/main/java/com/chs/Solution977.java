package com.chs;

public class Solution977 {

    public int[] sortedSquares(int[] A) {

        int left = 0;
        int right = A.length - 1;
        int index = A.length - 1;

        int[] result = new int[A.length];

        while (left <= right) {

            int a = A[left] * A[left];
            int b = A[right] * A[right];

            if (a > b) {
                result[index--] = a;
                left++;
            } else {
                result[index--] = b;
                right--;
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
