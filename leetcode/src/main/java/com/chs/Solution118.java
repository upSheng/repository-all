package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/9 15:39
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);


        for (int i = 1; i < numRows; i++) {

            List<Integer> pre = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < pre.size(); i++) {
                row.add(pre.get(j) + pre.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}
