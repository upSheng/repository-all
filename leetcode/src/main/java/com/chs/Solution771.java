package com.chs;

import java.util.HashSet;
import java.util.Set;

public class Solution771 {
    public int numJewelsInStones(String J, String S) {

        Set<Character> set = new HashSet();

        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        int result = 0;
        for (char ch : S.toCharArray()) {
            if (set.contains(ch)) {
                result++;
            }
        }
        return result;

    }
}
