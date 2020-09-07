package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/2 9:20
 */
public class Solution343 {
    public static int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 2; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }

        return dp[n];

    }

    public static void main(String[] args) {
        integerBreak(10);
    }
}
