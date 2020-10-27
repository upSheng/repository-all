package com.chs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/26 10:19
 */
public class Solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;
        int[] result = new int[length];
        System.arraycopy(nums, 0, result, 0, length);

        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], i));
        }
        for (int i = 0; i < length; i++) {
            result[i] = map.get(result[i]);
        }
        return result;
    }
}
