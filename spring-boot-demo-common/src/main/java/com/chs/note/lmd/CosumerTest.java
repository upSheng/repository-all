package com.chs.note.lmd;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/1/22<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/1/22            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class CosumerTest {

    public static void main(String[] args) {

        Consumer f1 = (x)-> System.out.println("f1"+x);
        Consumer f2 = (x)-> System.out.println("f2"+x);

        f1.andThen(f2).accept("xx");


        Function<Integer,Integer> f3 = (x)-> x*x;

        Integer y = f3.apply(3);
        System.out.println(y);

    }
}
