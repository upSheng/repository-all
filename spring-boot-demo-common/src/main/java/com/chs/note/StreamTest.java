package com.chs.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        /**
         * name             age
         * zhangsan         14
         * lisi             15
         * wangwu           16
         */
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","zhangsan");
        map1.put("age",14);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","lisi");
        map2.put("age",15);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("name","wangwu");
        map3.put("age",16);

        Map<String,Object> map4 = new HashMap<>();
        map4.put("name","zhangsan");
        map4.put("age",17);

        List<Map<String,Object>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);

        mapList.forEach(System.out::println);

        //过滤
        List<Map<String,Object>> mapList2 = mapList.stream().filter(map1c->  map1c.get("name").equals("zhangsan")).collect(Collectors.toList());

        System.out.println("过滤");
        mapList2.forEach(System.out::println);

        //分组

        Map<String, List<Map<String, Object>>> mapList3 = mapList.stream().collect(Collectors.groupingBy(map -> map.get("name").toString()));

        System.out.println("分组");
        mapList3.forEach((k,list)->{
            System.out.println(k + " "+ list.toString());
        });




     }
}
