package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/26 17:21
 */
public class Solution172 {
    public int trailingZeroes(int n) {

        int count = 0;
        while (n > 0) {
            n /= 5;
            count = count + n;
        }
        return count;
    }


}
