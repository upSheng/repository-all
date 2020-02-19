package com.chs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
public class Solution56 {
    public int[][] merge(int[][] intervals) {

        if(intervals.length==0) return new int[][]{};

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> lists = new ArrayList<>();

        int x = intervals[0][0];
        int y = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] > y) {
                lists.add(new int[]{x, y});

                x = intervals[i][0];
                y = intervals[i][1];


            } else {
                y = Math.max(y, intervals[i][1]);
            }

        }
        lists.add(new int[]{x, y});


        int[][] result = new int[lists.size()][2];

        for (int i = 0; i < lists.size(); i++) {

            result[i] = lists.get(i);
        }


        return result;
    }
}
