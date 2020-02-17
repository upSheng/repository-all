package com.chs;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/17<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/17            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution34 {

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};


        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] arr = new int[2];
        arr[0] = searchRange(nums, target, true);
        arr[1] = searchRange(nums, target, false);
        return arr;
    }

    public static int searchRange(int[] nums, int target, boolean left) {
        if (nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                if (left) {
                    high = mid;
                } else {
                    low = mid;

                    if (nums[high] == target) {
                        return high;
                    } else {
                        high--;
                    }

                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return nums[low] == target ? low : -1;

    }
}
