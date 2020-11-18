package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/18 10:01
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int index = 0;
        int sum = 0;
        int length = gas.length;
        for (int i = 0; index < length; i++) {

            sum += gas[i % length] - cost[i % length];

            if (i - index + 1 == gas.length && sum >= 0) {
                return index;
            }
            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        solution134.canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4});
    }
}
