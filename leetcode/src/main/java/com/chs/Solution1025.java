package com.chs;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/24 13:34
 */
public class Solution1025 {

    public static boolean divisorGame(int N) {

        if (N == 1) return false;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[1] = 0;

        for (int i = 2; i < N + 1; i++) {

            if (dp[i] != -1) {
                continue;
            }
            for (int j = 1; j < i; j++) {

                if (i % j == 0 && dp[i - j] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
            if (dp[i] == -1) {
                dp[i] = 0;
                int temp = i + i;
                while (temp <= N) {
                    dp[temp] = 1;
                    temp = temp + temp;
                }
            }
        }

        return dp[N] == 1;
    }

    public static void main(String[] args) {
        boolean b = divisorGame(9);
        System.out.println(b);
    }
}
