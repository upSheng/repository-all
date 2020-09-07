package com.chs;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/8 9:40
 */
public class Solution16a11 {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k==0) return new int[]{};

        Set<Integer> set = new LinkedHashSet<>();
        int temp = 0;
        for (int i = 0; i <= k; i++) {

            temp = (longer * i) + shorter * (k - i);
            set.add(temp);
        }

        int[] result = new int[set.size()];

        int i = 0;
        for (Integer val : set) {
            result[i] = val;
            i++;
        }
        return result;


    }

    public static void main(String[] args) {
        divingBoard(2,1118596,979);
    }
}
