package com.chs;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/17<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/17            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution46 {
    public static int translateNum(int num) {

        String temp = String.valueOf(num);
        if (temp.length() == 1) return 1;

        int[] result = new int[temp.length()];
        result[0] = 1;
        result[1] = Integer.parseInt(temp.substring(0, 2)) <= 25 ? 2 : 1;
        for (int i = 2; i < temp.length(); i++) {

            int anInt = Integer.parseInt(temp.substring(i - 1, i + 1));
            if (anInt <= 25 && anInt >9) {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[result.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        String temp = String.valueOf(x);
        int i = 0;
        int j = temp.length();
        while(i<j){
            if(temp.charAt(i) != temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
