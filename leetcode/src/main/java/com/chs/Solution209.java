package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/28 9:37
 */
public class Solution209 {
    public static int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;

        while (right < nums.length) {

            sum = sum + nums[right];

            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum = sum - nums[left];
                left++;
            }

            right++;

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int b = minSubArrayLen(11, a);
        System.out.println(b);
    }
}
