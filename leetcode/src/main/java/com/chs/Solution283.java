package com.chs;

public class Solution283 {

    public void moveZeroes(int[] nums) {

        int index = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                if (index != -1) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                    index++;

                }
            } else {
                if (index == -1) {
                    index = i;
                }
            }
        }
    }
}
