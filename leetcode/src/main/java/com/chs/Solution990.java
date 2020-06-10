package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/8 13:53
 */
public class Solution990 {

    public boolean equationsPossible(String[] equations) {

        int[] data = new int[26];

        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(data, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(data, equation.charAt(0) - 'a') == find(data, equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return false;
    }

    private void union(int[] data, int x, int y) {

        data[find(data, x)] = find(data, y);
    }

    private int find(int[] data, int x) {

        while (data[x] != x) {
            x = data[x];
        }
        return x;
    }

    public static void main(String[] args) {

        Solution990 solution990 = new Solution990();
        String[] aa = new String[]{"a!=a"};
        System.out.println(solution990.equationsPossible(aa));
    }
}
