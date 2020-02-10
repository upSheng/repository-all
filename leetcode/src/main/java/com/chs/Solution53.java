package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/10<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/10            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {

        int max = nums[0];

        int v = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (v < 0) {
                v = 0;
            }
            v = v + nums[i];
            max = Math.max(max, v);

        }

        return max;
    }
}
