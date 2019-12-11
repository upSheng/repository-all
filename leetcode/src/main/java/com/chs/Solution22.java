package com.chs;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        kh(list,"",0,0,n);

        return list;
    }

    public void kh(List<String> list, String str, int open, int close, int max){


        if(str.length() == 2*max){
            list.add(str);
            return ;
        }

        if(open< max){
            kh(list, str+"(",open+1,close,max);
        }

        if(close<open){
            kh(list, str+")",open,close+1,max);
        }
    }


}
