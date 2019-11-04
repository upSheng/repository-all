package com.chs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {

        int re =0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        List<String> list = new ArrayList<>();
        list.add("IV");
        list.add("IX");
        list.add("XL");
        list.add("XC");
        list.add("CD");
        list.add("CM");

        for(int i=0; i<s.length();i++){

            if(i+2>s.length() || list.indexOf(s.substring(i,i+2))==-1){
                re = re + map.get(s.charAt(i));
            }else{
                re = re - map.get(s.charAt(i));
            }
        }

        return re;
    }
}
