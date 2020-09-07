package com.chs;

import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/9 9:54
 */
public class Solution17a13 {

    public int respace(String[] dictionary, String sentence) {

        Arrays.sort(dictionary);
        Map<String,Integer> map = new HashMap<>();
        for (int i=0; i<dictionary.length; i++){
            map.put(dictionary[i],i);
        }

        return help(dictionary,sentence,0,map);
    }

    public int help(String[] dictionary, String sentence, int index, Map<String,Integer> map){

        return 0;

    }
}
