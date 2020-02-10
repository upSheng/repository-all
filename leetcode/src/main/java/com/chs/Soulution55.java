package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/8<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/8            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Soulution55 {

    public static void main(String[] args) {
        int[] nums = {0};
        Boolean b = canJump(nums);
    }

    public static boolean canJump(int[] nums) {

        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {

            if (i <= max) {
                index = i + nums[i];
            }

            if (index > max)
                max = index;

            if (max >= nums.length-1) {
                return true;
            }

        }

        return false;

    }
}
