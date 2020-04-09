package com.chs.note.sort;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/7<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/7            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class SortQuick {

    public static void main(String[] args) {
        int[] arr = {31, 0, 8, 1, 4, 4, 2};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach((x) -> System.out.print(x));

    }

    public static void sort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int low = start;
        int high = end;

        while (low < high) {

            while (arr[high] >= arr[start] && low < high) {
                high--;
            }

            while (arr[low] <= arr[start] && low < high) {
                low++;
            }


            if (low == high) {
                swap(arr, low, start);
                sort(arr, start, low - 1);
                sort(arr, low + 1, end);
            } else {
                swap(arr, low, high);
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
