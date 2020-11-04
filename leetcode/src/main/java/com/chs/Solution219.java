package com.chs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/2 14:17
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
