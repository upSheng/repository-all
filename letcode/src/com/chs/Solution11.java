package com.chs;

public class Solution11 {

    public static void main(String[] args) {
        int[] arry = {3,4,2,6,10,8};

        System.out.println(solution(arry));


    }

    public static int solution(int[] height){


        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l<r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));

            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }

        return maxArea;
    }

}
