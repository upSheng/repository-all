package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/2 19:11
 */
public class Soulution29 {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (divisor == 1) return dividend;

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        int result = 0;
        int count = 1;
        int i =0;

        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        int temp = divisor;


        while (dividend >= divisor) {
            while (dividend >= temp + temp && i<20) {
                i++;
                temp = temp + temp;
                count = count + count;
            }
            dividend = dividend - temp;
            temp = divisor;
            result = result + count;
            count = 1;
            i=0;
        }

        return flag ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(7, 2));

        System.out.println(Integer.MIN_VALUE);
    }

}
