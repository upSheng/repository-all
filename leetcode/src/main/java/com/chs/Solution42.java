package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/12<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/12            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution42 {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {


        int area = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 1; i < height.length - 1; i++) {

            maxLeft = 0;
            maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j <height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            area = area + Math.min(maxLeft, maxRight) - height[i];

        }

        return area;


    }


}
