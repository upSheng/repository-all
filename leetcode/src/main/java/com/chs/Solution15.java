package com.chs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] a = new int[]{0,0,0,0};
        List<List<Integer>> result = threeSum(a);

        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length<3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {


            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {


                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);


                    while (left<right  && nums[left] == nums[left+1]) left++;
                    left++;

                    while (left<right && nums[right] == nums[right-1]) right--;
                    right--;
                } else if (sum < 0) {
                    left++;


                } else {

                    right--;

                }
            }

        }

        return result;
    }
}
