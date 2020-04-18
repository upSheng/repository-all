package com.chs.util;

import com.csvreader.CsvReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/17 14:53
 */
public class CsvUtil {


    public static List<String[]> getDataList(String filePath) {
        List<String[]> dataList = new ArrayList<String[]>();
        CsvReader reader = null;
        InputStream in = null;

        try {
            String charset = "UTF-8";
            in = new FileInputStream(filePath);

            //csv第一行会多个字符
            in = getInputStream(in);
            reader = new CsvReader(in, ',', Charset.forName(charset));
            if (reader != null) {

                while (reader.readRecord()) {
                    dataList.add(reader.getValues());
                }
                if (!dataList.isEmpty()) {
                    // 数组转对象
                    return dataList;
                }
            }
        } catch (Exception e) {

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    private static InputStream getInputStream(InputStream in) throws IOException {

        PushbackInputStream stream = new PushbackInputStream(in);
        int ch = stream.read();
        if (ch != 0xEF) {
            stream.unread(ch);
        } else if ((ch = stream.read()) != 0xBB) {
            stream.unread(ch);
            stream.unread(0xef);
        } else if ((ch = stream.read()) != 0xBF) {
            throw new IOException("错误的UTF-8格式文件");
        }
        return stream;
    }

}