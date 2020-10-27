package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/26 10:55
 */
public class Solution168 {

    public String convertToTitle(int n) {


        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--;
            stringBuilder.append((char) ('A' + n % 26));
            n /= 26;
        }
        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        String s = solution168.convertToTitle(1);
        System.out.println(s);
    }
}
