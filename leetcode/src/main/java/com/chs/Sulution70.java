package com.chs;

import java.util.HashMap;
import java.util.Map;

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
public class Sulution70 {

    public int longestPalindrome(String[] words) {

        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        int n = 0;
        for(String key : map.keySet()){

            n += Math.min(map.get(key),map.getOrDefault(new StringBuilder(key).reverse().toString(),0));
        }
        return 2*n;

    }

    public static void main(String[] args) {
        Sulution70 s = new Sulution70();
        System.out.println(s.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
    }
}
