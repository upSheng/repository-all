package com.chs;

/**
 * 头疼。。
 * @author : HongSheng.Chen
 * @date : 2020/6/22 11:43
 */
public class Solution1618 {

    public boolean patternMatching(String pattern, String value) {

        int[] x = new int[3];
        for (char p : pattern.toCharArray()) {
            if (p == 'a') {
                x[0] = x[0] + 1;
            } else {
                x[1] = x[1] + 1;
            }
        }

        String q = null, p = null;

        for (int i = 1; i <= value.length(); i++) {

            int remain = value.length() - x[0] * i;
            if (remain % x[1] == 0) {
                int j = remain / x[1];

                for (int k = 0; k < pattern.length(); k++) {
                    if (pattern.charAt(k) == 'a' && q == null) {
                        q = value.substring(k);
                    }
                }
            }
        }
        return false;
    }
}
