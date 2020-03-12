package com.chs;

import java.util.Arrays;

public class Solution322 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(coinChange(arr, 11));
    }

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        return ch(coins, amount, 0);
    }

    public static int ch(int[] coins, int amount, int count) {


        for (int i = coins.length - 1; i >= 0; i--) {

            if (amount - coins[i] == 0) return count + 1;
            else if (amount - coins[i] > 0) {
                return ch(coins, amount - coins[i], count + 1);
            }

        }

        return -1;

    }
}
