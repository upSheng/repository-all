package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 */
public class Solution6 {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        Boolean goDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);

            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow = curRow + (goDown ? 1 : -1);
        }

        StringBuilder r = new StringBuilder();
        for (StringBuilder sb : list) {
            r.append(sb);
        }

        return r.toString();

    }
}
