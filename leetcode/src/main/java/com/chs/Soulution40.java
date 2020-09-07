package com.chs;

import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/11 15:01
 */
public class Soulution40 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        help(result, candidates, 0, target, new LinkedList<>());
        return result;
    }

    private void help(List<List<Integer>> result, int[] candidates, int begin, int target, Deque<Integer> deque) {

        if (target == 0) {
            result.add(new ArrayList<>(deque));
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            if (i > begin && candidates[i] == begin) {
                continue;
            }
            deque.addLast(candidates[i]);
            help(result, candidates, i + 1, target - candidates[i], deque);
            deque.removeLast();
        }

    }

    public static void main(String[] args) {

        List<Date> list = new ArrayList<>();

        list.add(getRandomDate());
        list.add(getRandomDate());
        list.add(getRandomDate());
        list.add(getRandomDate());
        list.add(getRandomDate());



        System.out.println(list);

    }
    private static Date getRandomDate() {
        Random random = new Random();
        long time = System.currentTimeMillis() - random.nextInt(10) * 1000;
        return new Date(time);
    }
}
