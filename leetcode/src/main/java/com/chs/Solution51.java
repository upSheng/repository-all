package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/7 19:09
 */
public class Solution51 {


    public static List<List<String>> solveNQueens(int n) {

        int[] col = new int[n];
        int[] main = new int[2 * n];
        int[] second = new int[2 * n];
        int[] queen = new int[n];

        List<List<String>> result = new ArrayList<>();
        add(col, main, second, queen, result, 0, n);

        result.forEach(x-> x.forEach(y-> {System.out.println(y);
            System.out.println("");}));
        return result;

    }

    public static void add(int[] col, int[] main, int[] second, int[] queen, List<List<String>> result, int i, int n) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int x = 0; x < n; x++) {
                    sb.append(".");
                }
                sb.replace(queen[j],queen[j]+1,"Q");
                list.add(sb.toString());
            }
            result.add(list);
        }
        for (int j = 0; j < n; j++) {
            if (col[j] == 0 && main[j - i + n] == 0 && second[j + i] == 0) {
                col[j] = 1;
                main[j - i + n] = 1;
                second[j + i] = 1;
                queen[i] = j;

                add(col, main, second, queen, result, i + 1, n);

                col[j] = 0;
                main[j - i + n] = 0;
                second[j + i] = 0;
                queen[i] = 0;
            }

        }
    }

    public static void main(String[] args) {

        solveNQueens(4);
    }


}
