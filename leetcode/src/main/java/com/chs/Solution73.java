package com.chs;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/22 16:33
 */
public class Solution73 {


    public void setZeroes(int[][] matrix) {


        int[] a = new int[matrix.length];
        int[] b = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    a[i] = 1;
                    b[j] = 1;
                }
            }
        }

        for (int i=0; i<a.length;i++){
            if (a[i]==1){
                Arrays.fill(matrix[i],0);
            }
        }

        for (int i=0; i<b.length;i++){
            if (b[i]==1){
                for(int j=0; j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }




    }
}
