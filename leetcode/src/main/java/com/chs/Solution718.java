package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/2 14:27
 */
public class Solution718 {
    public static int findLength(int[] A, int[] B) {

        int max = 0;

        int x = 0, y = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {

                x = i;
                y = j;
                while (x < A.length && y < B.length && A[x] == B[y]) {
                    x++;
                    y++;
                }
                max = Math.max(max, x - i);

            }

        }
        return max;
    }

    public static void main(String[] args) {
        int a = findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0});
        System.out.println(a);
    }
}
