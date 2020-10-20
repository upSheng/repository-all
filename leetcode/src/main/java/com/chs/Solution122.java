package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/13 17:28
 */
public class Solution122 {
    public int maxProfit(int[] prices) {

        int pre = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                result = result + prices[i] - pre;
            }
            pre = prices[i];
        }
        return result;
    }
}
