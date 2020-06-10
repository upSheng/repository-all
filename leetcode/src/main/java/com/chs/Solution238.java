package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/4 15:01
 */
public class Solution238 {
    public static int[] productExceptSelf(int[] nums) {


        int[] result = new int[nums.length];
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = nums[0];
        r[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i];
        }

        result[0] = r[1];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = l[i - 1] * r[i + 1];
        }
        result[nums.length - 1] = l[nums.length - 2];

        return result;


    }

    public static void main(String[] args) {
        int[] pa = new int[]{1, 2, 3, 4};
        productExceptSelf(pa);
    }
}
