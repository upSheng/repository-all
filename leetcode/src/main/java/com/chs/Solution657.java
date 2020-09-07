package com.chs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/28 17:36
 */
public class Solution657 {

    public boolean judgeCircle(String moves) {


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < moves.length(); i++) {

            map.put(moves.charAt(i),map.getOrDefault(moves.charAt(i),0)+1);
        }

        return map.getOrDefault('L',0).equals(map.getOrDefault('R',0)) && map.getOrDefault('U',0).equals(map.getOrDefault('D',0))  ;
    }
}
