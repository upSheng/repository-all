package com.chs.note.juc;

import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/6<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/6            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class CuTest {

    public static void main(String[] args) throws IOException {

        File file = new File("d:/a.txt");
        File file2 = new File("d:/b.txt");



        InputStream is = null;
        OutputStream os = null;
        try {

            is = new FileInputStream(file);
            os = new FileOutputStream(file2);

            byte[] temp = new byte[1024];
            int length;

            while ((length = is.read(temp)) != -1) {
                os.write(temp, 0, length);
            }


        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            is.close();
            os.close();


        }


    }
}
