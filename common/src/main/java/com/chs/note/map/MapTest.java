package com.chs.note.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/8 14:34
 */
public class MapTest {


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","chs");

        HashMap c = new HashMap();
        c.put("name","chs");

        HashMap clone = (HashMap) c.clone();


        String a = "aa";
        System.out.println(a.hashCode());
    }
}
