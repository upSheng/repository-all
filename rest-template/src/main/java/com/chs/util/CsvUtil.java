package com.chs.util;

import com.csvreader.CsvReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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



}
