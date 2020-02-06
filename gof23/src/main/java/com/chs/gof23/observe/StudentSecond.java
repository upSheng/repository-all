package com.chs.gof23.observe;

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
public class StudentSecond implements Student {
    @Override
    public void update(String msg) {
        System.out.println("studnetSecond收到"+msg);
    }
}
