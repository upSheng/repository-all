package com.chs;

import java.util.Stack;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/10 17:16
 */
public class Solution224 {

    public int calculate(String s) {

        String s1 = s.replaceAll(" ", "");

        Stack<Character> stack1 = new Stack<>();

        Stack<Character> stack2 = new Stack<>();

        for (int i=0; i<s.length();i++){

            if (s.charAt(i) == '('){
                stack1.push('(');
            }

            if (s.charAt(i) == ')'){
                stack1.pop();
            }
        }

        return 0;
    }
}
