package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/28 15:56
 */
public class Solution41 {

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {

            int num = Math.abs(nums[i]);

            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }

        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int a = firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println(a);
    }
}
