package com.chs.note;

public class Binary {

    public static void main(String[] args) {

        //首位为符号位， 0为正，1为负， 以补码的形式展示
        System.out.println("5二进制: " +Integer.toBinaryString(-5));
        System.out.println("-5二进制: " +Integer.toBinaryString(-5));

        // 位运算
        // 有符号移动 >> <<    负数时右移高位补1,其他情况补0
        // 无符号右移 >>> 高位补0

        System.out.println(35>>1);  //17
        System.out.println(35<<1);  //70

        System.out.println(-35>>>1); //高位补0会变正

        // 位移动时约定 int %32 次, long %64 次;


        System.out.println(35>> 33); //17    与35>>1结果相同

        // & 按位与运算 两边都为1时值为1 其他为0
        // | 按位或运算 两边其中有一个为1时值为1 其他为0
        // ^ 按位异或   两边一样时值为1 其他为0
        // ~ 按位取反    0 取反1 1取反0


        System.out.println(1&1); //1
        System.out.println(1|0); //1
        System.out.println(1^1); //0
        System.out.println(~5); // -6
    }
}
