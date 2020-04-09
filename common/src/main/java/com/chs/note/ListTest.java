package com.chs.note;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/1/21<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/1/21            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("ad");

        List<String> ll = list.stream().filter((x)-> x.startsWith("a")).collect(Collectors.toList());

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            String str = iterator.next();
            if(str.startsWith("a")){
                iterator.remove();
            }
        }

        list.forEach((x)-> System.out.println(x));
    }
}
