package com.chs;

public class Solution461 {

    public int hammingDistance(int x, int y) {

        int temp = x ^ y;

        String str = Integer.toBinaryString(temp);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }

        return result;
    }
}
