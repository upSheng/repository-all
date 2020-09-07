package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/22 13:50
 */
public class Solutiona11 {

    public int minArray(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers.length == 0 ? 0 : numbers[0];
    }
}
