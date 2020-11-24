package com.chs;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/19 15:13
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
