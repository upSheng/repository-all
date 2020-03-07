package com.chs;

import java.util.Arrays;

public class Solution1103 {

    public int[] distributeCandies(int candies, int num_people) {

        int[] result = new int[num_people];

        Arrays.fill(result, 0);
        int index = 1;

        while (candies > 0) {

            for (int i = 0; i < num_people; i++) {

                if (candies >= index) {
                    result[i] = result[i] + index;
                    candies = candies - index;
                    index++;
                } else {
                    result[i] = result[i] + candies;
                    return result;
                }

            }

        }
        return result;
    }
}
