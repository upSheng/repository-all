package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/23<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/23            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution75 {


    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

    }

    public static void sortColors(int[] nums) {

        int i = 0;
        int j = 0;


        for (int num : nums) {
            if (num == 0) i++;
            if (num == 1) j++;

        }

        for (int k = 0; k < nums.length; k++) {

            if (i > 0) {
                nums[k] = 0;
                i--;
                continue;
            }

            if (j > 0) {
                nums[k] = 1;
                j--;
                continue;
            }
            nums[k] = 2;
        }


    }
}
