package com.chs;

public class Solution5 {

    public void t(String s) {

        int max = 0,j=0,k=0;
        String maxStr = "";

        int length = s.length();
        for (int i = 0; i < length; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                 j = i;
                 k = i + 1;


                while (s.charAt(j) == s.charAt(k)) {

                    if (j <= 0) {
                        break;
                    }
                    if (k >= length-1) {
                        break;
                    }

                    j--;
                    k++;

                }

            }

            if(k-j+1>max){
                max = k-j+1;
                maxStr = s.substring(j,k+1);
            }




        }

    }


    private String getStr(String s, int index) {
        return "";
    }
}
