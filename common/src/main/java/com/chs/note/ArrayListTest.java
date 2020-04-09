package com.chs.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //往容器中添加值
        list.add("aa");
        list.add("bb");
        list.add("cc");

        System.out.println(list.get(0));  // 通过索引获取值
        list.remove(0);  //通过索引移除
        list.remove("bb"); //通过值移除
        list.set(0, "dd");  //修改值

        list.clear(); //清空容器

        String[] src = new String[]{"aa","bb","cc"};
        String[] dest = Arrays.copyOf(src,6); //[aa, bb, cc, null, null, null]

        System.arraycopy(src,0,dest,0,src.length);



    }
}
