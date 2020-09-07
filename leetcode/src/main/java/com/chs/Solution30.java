package com.chs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/5 9:32
 */
public class Solution30 {

    public static List<Integer> findSubstring(String s, String[] words) {


        List<Integer> result = new ArrayList<>();

        Map<String, Integer> wordmap = Arrays.stream(words).collect(Collectors.groupingBy(x -> x, Collectors.reducing(0, x -> 1, Integer::sum)));

        int n1 = words.length;
        if (n1==0) return result;
        int n2 = words[0].length();
        String temp;
        boolean flag = true;

        Map<String, Integer> myMap = new HashMap<>();

        for (int i = 0; i <= s.length()-n1*n2; i++) {
            for (int j = 0; j < n1; j++) {

                temp = s.substring(i+(j * n2), i+(j * n2)+n2);
                if (wordmap.containsKey(temp)) {

                    int x = wordmap.get(temp);
                    int y = myMap.getOrDefault(temp, 0);
                    if (x == y) {
                        flag = false;
                        break;
                    }
                    myMap.put(temp, y + 1);
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
            flag = true;
            myMap.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
    }


}
