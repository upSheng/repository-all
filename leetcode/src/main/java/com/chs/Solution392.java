package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/27 16:38
 */
public class Solution392 {

    public boolean isSubsequence(String s, String t) {

        int n = s.length();
        if(n==0) return true;
        int count = 0;
        for(int i=0; i<t.length(); i++ ){
            if(s.charAt(count) == t.charAt(i)){
                count++;
                if (count == n){
                    return true;
                }
            }
        }
        return false;
    }
}
