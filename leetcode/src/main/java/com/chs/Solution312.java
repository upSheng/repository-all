package com.chs;

import java.util.ArrayList;
import java.util.List;

public class Solution312 {

    public List<String> printVertically(String s) {


        String str = s.trim();

        String[] arr = str.split(" ");

        int max = 0;
        for (String a : arr) {
            max = Math.max(max, a.length());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();

            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                char ch = i < arr[j].length() ? arr[j].charAt(i) : ' ';


                if (ch != ' ') {
                    index = j;
                }

                sb.append(ch);


            }

            String s1 = sb.toString();
            if (index > 0 && s1.charAt(s1.length() - 1) == ' ') {
                s1 = s1.substring(0, index + 1);
            }

            result.add(s1);
        }
        return result;
    }


}
