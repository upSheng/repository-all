package com.chs;

public class Solution69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(27));
    }

    public static int mySqrt(int x) {

        int left = 0;
        int right = x;

        while (left < right) {
            int mid = (left + right) / 2;

            long v = (long) mid * mid;

            if (mid == x) {
                return mid;
            } else if (v > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long k = (long) right * right;
        if (k > x) {
            return right - 1;
        }

        return right;
    }
}
