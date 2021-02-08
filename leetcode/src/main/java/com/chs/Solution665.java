package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/8 15:09
 */
public class Solution665 {

    public boolean checkPossibility(int[] nums) {

        int count = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                count++;
                if (count > 1) {
                    return false;
                }

                if (i - 2 < 0 || nums[i] >= nums[i - 2]) {
                    min = nums[i];
                }

            } else {
                min = nums[i];
            }

        }
        return true;

    }

    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();
        System.out.println(solution665.checkPossibility(new int[]{3, 4, 2, 3}));

    }
}
