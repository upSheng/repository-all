package com.chs;

import java.util.*;

public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>(map.keySet());

        Collections.sort(result, (s, t1) -> map.get(t1).equals(map.get(s)) ?  s.compareTo(t1): map.get(t1) - map.get(s));
        return result.subList(0,k);
    }
}
