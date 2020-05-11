package com.chs.util;

import com.csvreader.CsvReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

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

    public static List<List<String>> getExcel(String filePath) {

        try {

            List<List<String>> result = new ArrayList<>();
            InputStream is = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 0; i <= rowNum; i++) {
                //获得行
                Row row = sheet.getRow(i);
                if (row==null) continue;
                List<String> item = new ArrayList<>();
                //获得当前行的列数
                int colNum = row.getLastCellNum();
                for (int j = 0; j < colNum; j++) {
                    //获取单元格
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        if (StringUtils.isEmpty(cell.toString())){
                            continue;
                        }
                        if (j == 0 || j == 1) {

                            item.add(Double.valueOf(cell.toString()).intValue() + "");

                        } else {
                            if (!(StringUtils.isEmpty(cell.toString()))) {
                                item.add(cell.toString());
                            }

                        }

                    }
                }
                if (!item.isEmpty()){
                    result.add(item);
                }

            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static List<List<String>> getExcelUuid(String filePath) {

        try {

            List<List<String>> result = new ArrayList<>();
            InputStream is = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 0; i <= rowNum; i++) {
                //获得行
                Row row = sheet.getRow(i);
                List<String> item = new ArrayList<>();
                //获得当前行的列数
                int colNum = row.getLastCellNum();
                for (int j = 0; j < colNum; j++) {
                    //获取单元格
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        item.add(cell.toString());
                    }
                }
                result.add(item);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
