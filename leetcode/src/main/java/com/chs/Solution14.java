package com.chs;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Solution14 {


    public static String longestCommonPrefix(String[] strs) {


        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {


            while (strs[i].indexOf(result) != 0) {

                result = result.substring(0, result.length() - 1);

                if (result.isEmpty()) return "";
            }

        }
        return result;
    }


}
