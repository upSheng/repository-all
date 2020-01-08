package com.chs.note;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        String name = map.get("name");
    }
}
