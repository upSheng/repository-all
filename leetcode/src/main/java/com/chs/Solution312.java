package com.chs;

public class Solution312 {

    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] vals = new int[n+2];
        System.arraycopy(nums,0,vals,1,n);
        vals[0] = 1;
        vals[1] = 1;

        int[][] dp = new int[n+2][n+2];


        for (int i=1; i<vals.length-1; i++){

        }


        return 0;
    }

}
