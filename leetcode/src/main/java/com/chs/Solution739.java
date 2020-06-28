package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/11 9:57
 */
public class Solution739 {

    public static int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {


            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
