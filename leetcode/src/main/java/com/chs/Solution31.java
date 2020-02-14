package com.chs;

import java.util.Arrays;

public class Solution31 {

    public static void main(String[] args) {

        int a[]  = {1,2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
    public static   void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 &&   nums[i+1] <= nums[i] ) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;

            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private static void reverse(int[] nums, int start) {

        int i = nums.length - 1;
        while (start < i) {
            swap(nums, start, i);
            start++;
            i--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
