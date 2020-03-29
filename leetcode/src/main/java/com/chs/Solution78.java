package com.chs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/29 13:44
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        add(lists, list, nums, 0);
        return lists;
    }

    private void add(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {


        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        add(lists, list, nums, nums.length);

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            add(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }


    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("3");

        list.forEach((x) -> System.out.println(x));
    }
}
