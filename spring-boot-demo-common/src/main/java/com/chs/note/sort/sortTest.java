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
public class sortTest {

    public static void main(String[] args) {
        int[] arr = {3,2,5,4,1,8,9,6};
        sort(arr);

    }

    public static void sort(int[] arr){
        int temp;
        for(int i=0; i<arr.length-1;i++){
            for(int j=0; j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){

                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }
        Arrays.stream(arr).forEach((x)-> System.out.println(x));

    }
}
