package com.chs;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/19<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/19            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution62 {


    public static void main(String[] args) {


        int a = uniquePaths(3, 2);

        System.out.println(a);


    }


    public static int uniquePaths(int m, int n) {

        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + cur[j];
            }
        }
        return cur[n - 1];


    }


}
