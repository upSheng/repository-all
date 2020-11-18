package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/6 14:42
 */
public class Solution2312 {
    public boolean isPowerOfTwo(int n) {

        if (n <=0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n==1;

    }
}
