package com.chs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/11 19:04
 */
public class Solution77 {

    LinkedList<Integer> stack = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        add(0, k, n);

        return result;
    }


    private void add(int i, int k, int n) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int j = i + 1; j <= n; j++) {
            if (!stack.isEmpty() && stack.peek()>=j){
                continue;
            }
            stack.push(j);

            add(i + 1, k, n);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        Solution77 s = new Solution77();
        s.combine(4,2);
    }
}
