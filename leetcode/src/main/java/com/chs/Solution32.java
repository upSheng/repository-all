package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/14<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/14            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution32 {

    public static void main(String[] args) {

        String s = ")()())()()(";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {

        int[] arr = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                arr[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    arr[i] = i >= 2 ? arr[i - 2] + 2 : 2;
                } else {

                    if (i - arr[i - 1] - 1 >= 0 && s.charAt(i - arr[i - 1] - 1) == '(') {

                        arr[i] = (i - arr[i - 1] - 2) >= 0 ? arr[i - arr[i - 1] - 2] + arr[i - 1] + 2 : arr[i - 1] + 2;
                    }

                }
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
