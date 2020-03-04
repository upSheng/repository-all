package com.chs;

public class Solution762 {

    public static void main(String[] args) {

    }

    public int countPrimeSetBits(int L, int R) {


        int result = 0;
        for (int i = L; i <= R; ++i) {
            if (isZ(Integer.bitCount(i))) {
                result++;
            }

        }
        return result;


    }

    public boolean isZ(int num) {

        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
