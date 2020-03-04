package com.chs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {


        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {

            if (!map.containsKey(i)) {
                result.add(i);
            }
        }

        return result;

    }
}
