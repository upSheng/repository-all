package com.chs;

public class Solution31 {

    public static void main(String[] args) {

        int a[]  = {1,2,3};
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(a);
    }
    public  void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 &&   nums[i] > nums[i + 1] ) {
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

    private void reverse(int[] nums, int start) {

        int i = nums.length - 1;
        while (start < i) {
            swap(nums, start, i);
            start++;
            i--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
