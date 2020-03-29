package com.chs;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/26 16:50
 */
public class Solution581 {

    public static void main(String[] args) {
        int a[] = {2, 6, 4, 8, 10, 9, 15};
        findUnsortedSubarray(a);
    }

    public static int findUnsortedSubarray(int[] nums) {

        int[] snums = nums.clone();

        Arrays.sort(snums);

        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] != snums[i])) {
                min = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            if ((nums[i] != snums[i])) {
                max = i;
                break;
            }
        }

        return (min == 0 && max == 0) ? 0 : max - min + 1;
    }
}
