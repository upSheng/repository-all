package com.chs;

import java.util.Arrays;

public class Solution204 {

    public int countPrimes(int n) {

        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);

        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                for (int j = 2 * i; j < n; j+=i) {
                    dp[j] = false;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) result++;
        }
        return result;
    }


}
