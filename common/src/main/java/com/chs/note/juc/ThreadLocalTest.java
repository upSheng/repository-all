package com.chs.note.juc;

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
public class ThreadLocalTest {

    public static void main(String[] args) {

        Runnable r = new R();
        for(int i=0; i<10;i++){
            new Thread(r).start();
        }
    }
    static class R implements  Runnable{

        private Integer count = 0;

        private ThreadLocal<Integer> tCount = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() { //初始化存入的值
                return 0;
            }
        };

        public void add(){
            count = count + 5;
            tCount.set(tCount.get()+5);
        }

        @Override
        public void run() {
            add();
            System.out.println("count:"+count+"  tCount:"+tCount.get());
        }
    }
}
