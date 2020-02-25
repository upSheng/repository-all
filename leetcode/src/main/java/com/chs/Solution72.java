package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/22<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/22            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution72 {

    public static void main(String[] args) {

        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {


        int a = word1.length();
        int b = word2.length();

        if (a == 0) return b;
        if (b == 0) return a;

        int[][] dp = new int[a + 1][b + 1];
        dp[0][0] = 0;

        for (int i = 1; i < a + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < b + 1; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < a + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;

                }

            }
        }

        return dp[a][b];
    }
}
