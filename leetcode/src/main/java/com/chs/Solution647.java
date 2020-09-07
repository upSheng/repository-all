package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/19 9:41
 */
public class Solution647 {
    public int countSubstrings(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int offset = 1;
            result++;
            while (i - offset >= 0 && i + offset < s.length() && s.charAt(i - offset) == s.charAt(i + offset)) {
                result++;
                offset++;
            }

            offset = 1;
            while (i - offset >= 0 && i + offset-1 < s.length() && s.charAt(i - offset) == s.charAt(i + offset-1)) {
                result++;
                offset++;
            }
        }
        return result;
    }
}
