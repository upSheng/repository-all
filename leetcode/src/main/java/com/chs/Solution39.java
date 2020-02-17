package com.chs;

import java.util.ArrayList;
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
public class Solution39 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);
        System.out.println("a");

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        add(result, list, candidates, target);
        return result;

    }


    public static void add(List<List<Integer>> result, List<Integer> list, int[] candidates, int cur) {


        if (cur == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (cur < 0) return;

        Integer min = null;
        if (list.size() != 0) {
            min = list.get(list.size() - 1);
        }

        for (int i = 0; i < candidates.length; i++) {

            if (min == null || candidates[i] >= min) {

                list.add(candidates[i]);

                add(result, list, candidates, cur - candidates[i]);
                list.remove(list.size() - 1);
            }

        }


    }
}
