package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/9 16:19
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        result.add(1);
        if (rowIndex ==0){
            return result;
        }

        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);
            for (int j = result.size()-2; j>0 ; j--) {
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }
}
