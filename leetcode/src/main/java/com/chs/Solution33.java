package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/15<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/15            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution33 {


    public static void main(String[] args) {


        int[] arr = {3,1};

        System.out.println(search(arr, 1));
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            }


            if (nums[mid] >= nums[low]) {

                if (target >= nums[low] && target < nums[mid]) {

                    high = mid - 1;
                } else {
                    low = low + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;

    }


}
