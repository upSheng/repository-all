package com.chs;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/11<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/11            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution26 {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        removeDuplicates(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {


        int index = 0;


        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[index]) {

                nums[index + 1] = nums[i];
                index++;
            }


        }
        return index + 1;
    }
}
