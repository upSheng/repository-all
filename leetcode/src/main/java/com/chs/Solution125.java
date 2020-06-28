package com.chs;

public class Solution125 {

    public static void main(String[] args) {
        String a = ".,";
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(String s) {

        String str = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;



        while (left < right) {

            while (left < str.length() - 1 && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            while (right > 0 && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }



            if (str.charAt(left) != str.charAt(right) && Character.isLetterOrDigit(str.charAt(left))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
