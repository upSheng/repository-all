package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/10 10:30
 */
public class Solution696 {
    public int countBinarySubstrings(String s) {

        int last, cur, res; last = res = 0; cur = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) cur ++;
            else{last = cur; cur = 1;}
            if(last >= cur) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution696 solution696 = new Solution696();
        int i = solution696.countBinarySubstrings("00110");
        System.out.println(i);
    }
}
