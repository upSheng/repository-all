package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/29 16:48
 */
public class Solution43 {

    /**
     * num1 * num2
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int carry = 0, temp;

        StringBuilder sb = new StringBuilder();
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {

            //补0
            for (int j = num2.length() - 1 - i; j > 0; j--) {
                sb.append(0);
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                temp = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                sb.append(temp% 10);
                carry = temp / 10;

            }
            if (carry != 0) {
                sb.append(carry);
            }
            result = add(sb.reverse().toString(), result);

            sb.delete(0, sb.length());
            carry = 0;
        }

        return result;
    }

    private static String add(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int max = Math.max(num1.length(), num2.length());

        int carry = 0, n1, n2, temp;
        for (int i = 0; i < max; i++) {
            n1 = num1.length() - 1 - i >= 0 ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            n2 = num2.length() - 1 - i >= 0 ? num2.charAt(num2.length() - 1 - i) - '0' : 0;

            temp = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            sb.append(temp);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(multiply("9", "9"));
    }
}
