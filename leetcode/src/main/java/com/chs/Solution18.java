package com.chs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/1 19:04
 */
public class Solution18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();



        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int x = j + 1; x < nums.length; x++) {
                    for (int y = x + 1; y < nums.length; y++) {
                        if (nums[i] + nums[j] + nums[x] + nums[y] == target) {


                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[x]);
                            list.add(nums[y]);
                            result.add(list);

                        }
                    }
                }
            }
        }

        Set<List<Integer>> set = new TreeSet<>((o1, o2) -> {

            for (int i=0; i<4;i++){
                if (!o1.get(i).equals(o2.get(i))){
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;

        });

        set.addAll(result);
        result = new ArrayList<>(set);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        fourSum(nums, target);
    }
}
