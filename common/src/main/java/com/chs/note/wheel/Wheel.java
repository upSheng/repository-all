package com.chs.note.wheel;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/12 13:50
 */
public class Wheel {
    public static void main(String[] args) {

        String[] props = new String[]{"一等奖","二等奖","谢谢惠顾"};
        int[] weights = new int[]{1,2,7};
        TreeMap<Integer, String> treeMap = generate(weights,props);

        int sum = Arrays.stream(weights).sum();
        Random random = new Random();



        List<Integer> list = new ArrayList<>();

        for (int i=0; i<1000; i++){


           list.add(treeMap.tailMap(random.nextInt(sum)+1).firstKey());
        }

        Map<Integer,Long> result = list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));


        System.out.println();


    }

    private static TreeMap<Integer, String> generate(int[] weights, String[] props) {

        int sum = 0;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
            treeMap.put(sum, props[i]);
        }
        return treeMap;
    }
}
