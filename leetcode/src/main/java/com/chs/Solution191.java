package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/29 14:16
 */
public class Solution191 {

    public int hammingWeight(int n) {

        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}
