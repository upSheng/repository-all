package com.chs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/2 11:39
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        //Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        return list.stream().distinct().mapToInt(Integer::valueOf).toArray();

    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return set.size() == nums.length;

    }
}
