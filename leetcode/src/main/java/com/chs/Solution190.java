package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/29 16:06
 */
public class Solution190 {

    public int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {

            res = (res << 1) | (n & 1);
            n = n >> 1;
        }

        return res;

    }

    public static void main(String[] args) {

        int M1 = 0x55555555;
       Integer.reverse(5);
        Integer  a = 0x11111111;

        System.out.println(2 << 1);

        System.out.println(3 & 1);

        System.out.println(2 | 1);
    }
}
