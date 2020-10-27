package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/26 17:14
 */
public class Solution171 {
    public int titleToNumber(String s) {

        int result = 0;
        for (char ch : s.toCharArray()) {
            int a = ch - 64;
            result = result * 26 + a;
        }
        return result;
    }
}
