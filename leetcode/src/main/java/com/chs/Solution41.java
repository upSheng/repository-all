package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/28 15:56
 */
public class Solution41 {

    public int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                min = Math.min(min, nums[i]);
            }
        }
        return min - 1;
    }
}
