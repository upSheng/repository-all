package com.chs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/29 17:42
 */
public class Solution205 {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }

        return true;
    }

    public static void main(String[] args) {

        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("badc", "baba"));
    }
}
