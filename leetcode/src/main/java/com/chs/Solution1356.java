package com.chs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/6 13:40
 */
public class Solution1356 {


    public int[] sortByBits(int[] arr) {

        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(x -> x)).mapToInt(x -> x).toArray();
    }
}
