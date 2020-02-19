package com.chs;

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
public class Sulution70 {

    public int climbStairs(int n) {



        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i= 2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];

    }
}
