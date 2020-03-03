package com.chs;

import java.util.HashMap;
import java.util.Map;

public class Soulution169 {

    public int majorityElement(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
