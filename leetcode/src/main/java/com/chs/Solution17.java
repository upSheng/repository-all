package com.chs;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution17 {


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length()==0) return result;

        Map<Character,List<String>> map =new HashMap<>();
        map.put('2', Arrays.asList(new String[]{"a","b","c"}));
        map.put('3', Arrays.asList(new String[]{"d","e","f"}));
        map.put('4', Arrays.asList(new String[]{"g","h","i"}));
        map.put('5', Arrays.asList(new String[]{"j","k","l"}));
        map.put('6', Arrays.asList(new String[]{"m","n","o"}));
        map.put('7', Arrays.asList(new String[]{"p","q","r","s"}));
        map.put('8', Arrays.asList(new String[]{"t","u","v"}));
        map.put('9', Arrays.asList(new String[]{"w","x","y","z"}));


        if(digits.length() == 1) return map.get(digits.charAt(0));

        List<String> list = letterCombinations(digits.substring(0,digits.length()-1));

        List<String> last = map.get(digits.charAt(digits.length()-1));


        for(int i=0;i<list.size(); i++){

            for(int j=0;j<last.size();j++){
                result.add(list.get(i) + last.get(j));
            }

        }

        return result;
    }
}
