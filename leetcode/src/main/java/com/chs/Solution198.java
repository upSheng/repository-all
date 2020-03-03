package com.chs;

public class Solution198 {

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums[1] > (nums[0] + nums[2])) {
            dp[2] = nums[1];
        } else {
            dp[2] = nums[0] + nums[2];
        }

        int max = dp[2];

        for (int i = 3; i < nums.length; i++) {

            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
