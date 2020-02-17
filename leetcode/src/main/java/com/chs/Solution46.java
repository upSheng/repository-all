package com.chs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/17<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/17            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> result = permute(nums);

        System.out.println("a");
    }

    public static List<List<Integer>> permute(int[] nums) {


        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        int lenght = nums.length;
        add(result, lenght, list, 0);

        return result;


    }

    public static void add(List<List<Integer>> result, int length, List<Integer> nums, int index) {

        if (index == length) {
            result.add(new ArrayList<>(nums));
        }

        for (int i = index ; i < length; i++) {
            Collections.swap(nums, index, i);
            add(result, length, nums, index + 1);
            Collections.swap(nums, index, i);
        }
    }
}
