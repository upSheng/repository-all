package com.chs;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class Solution7 {


    public static int t(int x) {

        int re = 0, pop;

        while (x != 0) {
            pop = x % 10;

            if (re > (Integer.MAX_VALUE) / 10 || re < (Integer.MIN_VALUE) / 10) {
                return 0;
            }
            re = re * 10 + pop;
            x = x / 10;
        }
        return re;
    }
}
