package com.chs.note.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

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
public class BufferReaderTest {

    public static void main(String[] args) throws Exception {
        File file = new File("d:/a.txt");

        Reader r = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(r);

        String line = null;

        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
        r.close();

    }
}
