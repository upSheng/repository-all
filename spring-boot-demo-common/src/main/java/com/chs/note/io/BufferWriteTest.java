package com.chs.note.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

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
public class BufferWriteTest {

    public static void main(String[] args) throws Exception {
        File file = new File("d:/a.txt");

        Writer writer = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("hello world");
        bufferedWriter.newLine();
        bufferedWriter.write("hello world");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
