package com.chs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/6 14:04
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        int temp = nums[0];
        int tempCount = 0;
        for (int i = 1; i < nums.length; i++) {

            if (temp + tempCount + 1 == nums[i]) {
                tempCount++;

            } else {

                if (tempCount == 0) {
                    result.add(String.valueOf(temp));
                } else {
                    result.add(temp + "->" + (temp + tempCount));
                }
                temp = nums[i];
                tempCount = 0;

            }
        }
        if (tempCount == 0) {
            result.add(String.valueOf(temp));
        } else {
            result.add(temp + "->" + (temp + tempCount));
        }

        return result;

    }
}
