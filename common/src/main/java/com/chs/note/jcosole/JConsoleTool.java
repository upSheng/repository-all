package com.chs.note.jcosole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 16:19
 */
public class JConsoleTool {

    /**
     * -Xms100M -Xms100m -XX:+UseSerialGC -XX:+PrintGCDetails
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        Thread.sleep(20000); //先运行程序，在执行监控
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        while(true){
            //让其一直运行着
        }

    }

}
