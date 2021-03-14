package com.chs;

import java.util.Stack;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/9 10:07
 */
public class Solution1047 {

    public String removeDuplicates(String S) {

        Stack<Character> stack = new Stack();

        for (char c : S.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek().equals(c)) {

                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        System.out.println(solution1047.removeDuplicates("abbaca"));
        ;
    }
}
