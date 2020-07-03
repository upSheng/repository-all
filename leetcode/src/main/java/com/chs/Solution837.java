package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/1 10:20
 */
public class Solution837 {

    public static double new21Game(int N, int K, int W) {


        if (K==0){
            return 1;
        }

        double[] dp = new double[K + W];

        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1;
        }
        for (int i = N + 1; i < K + W; i++) {
            dp[i] = 0;
        }
        double sum = 0.0;
        for (int j = 1; j <= W; j++) {
            sum += dp[K - 1 + j];
        }
        dp[K - 1] = sum / W;
        for (int i = K - 2; i >= 0; i--) {


            sum = sum + dp[i + 1] - dp[i + 1 + W];
            dp[i] = sum / W;

        }
        return dp[0];
    }

    public static void main(String[] args) {
        double v = new21Game(1, 0, 1);
        System.out.println(v);


    }
}
