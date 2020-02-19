package com.chs;

import java.util.*;

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
public class Solution49 {


    public static void main(String[] args) {

        String[] cc = {"bac","kk","aa"};


        System.out.println(Arrays.toString(cc));
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strSort = String.valueOf(chars);
            if (!map.containsKey(strSort)){
                map.put(strSort,new ArrayList<>());
            }
            map.get(strSort).add(str);

        }
        return new ArrayList<>(map.values());

    }



}
