package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/30 11:11
 */
public class Solution557 {

    public String reverseWords(String s) {

        String[] list = s.split(" ");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.length; i++) {

            result.append(new StringBuilder().append(list[i]).reverse());

            if (i != list.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
