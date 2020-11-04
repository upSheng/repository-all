package com.chs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/29 15:10
 */
public class Solution202 {

    public boolean isHappy(int n) {


        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int result = 0;
            while (n >= 10) {
                int a = n % 10;
                result += a * a;
                n /= 10;
            }
            result += n * n;
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
            }
            n = result;
        }

        return true;


    }


}
