package com.chs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution848 {

    public String[] uncommonFromSentences(String A, String B) {

        String[] arr1 = A.split(" ");
        String[] arr2 = B.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String arr : arr1) {
            map.put(arr, map.getOrDefault(arr, 0) + 1);

        }
        for (String arr : arr2) {
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                list.add(entry.getKey());
            }
        }

        String[] result = new String[list.size()];
        list.toArray(result);
        return result;

    }
}
